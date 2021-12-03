![LDBC logo](ldbc-logo.png)
# LDBC SNB Interactive workload implementations

Reference implementations of the LDBC Social Network Benchmark's Interactive workload ([paper](https://homepages.cwi.nl/~boncz/snb-challenge/snb-sigmod.pdf), [specification on GitHub pages](https://ldbcouncil.org/ldbc_snb_docs/), [specification on arXiv](https://arxiv.org/pdf/2001.02299.pdf)).

To get started with the LDBC SNB benchmarks, check out our introductory presentation: [The LDBC Social Network Benchmark](https://docs.google.com/presentation/d/1p-nuHarSOKCldZ9iEz__6_V3sJ5kbGWlzZHusudW_Cc/).

## Notes

:warning: There are some quirks to using this repository:

* The goal of the implementations in this repository is to serve as **reference implementations** which other implementations can cross-validated against. Therefore, our primary objective was readability and not absolute performance when formulating the queries.

* SNB data sets of **different scale factors require different configurations** for the benchmark runs. Therefore, make sure you use the correct values (update_interleave and query frequencies) based on the files provided in the [`sf-properties` directory](sf-properties/).

* The default workload contains updates which are persisted in the database. Therefore, **the database needs to be reloaded or restored from backup before each run**. Otherwise, repeated updates would insert duplicate entries.

* We expect most systems-under-test to use multi-threaded execution for their benchmark runs. **To allow running the benchmark workload on multiple threads, the update stream files need to be partitioned accordingly by the generator.** We have pre-generated these for 16 frequent partition numbers (1, 2, ..., 1024 and 48, 96, ..., 768) and scale factors up to 1000 (their deployment is [in progress](#benchmark-data-sets)).

## Implementations

We provide two reference implementations:

* [Neo4j (Cypher) implementation](cypher/README.md)
* [PostgreSQL (SQL) implementation](postgres/README.md)

For both, the database system is running in a Docker container to simplify the setup of the benchmark environment.
For detailed instructions, consult the READMEs of the projects.

## User's guide

1. Build the projects (skips running the tests which need live databases):

   ```bash
   ./build.sh
   ```

2. For each implementation, it is possible to perform to perform the run in one of three modes:

    a. Create validation parameters with the `driver/create-validation-parameters.sh` script.

      * **Input:** The query substitution parameters are taken from the value set in `ldbc.snb.interactive.parameters_dir` configuration property.
      * **Output:** The results will be stored (by default) in the `validation_params.csv` file.
      * **Parallelism:** The execution must be single-threaded to ensure a deterministic order of operations.

    b. Validate against existing validation parameters with the `driver/validate.sh` script.

      * **Input:** The query substitution parameters are taken (by default) from the `validation_params.csv` file.
      * **Output:** The results of the validation are printed to the console. If the valiation failed, the results are saved to the `validation_params-failed-expected.json` and `validation_params-failed-actual.json` files.
      * **Parallelism:** The execution must be single-threaded to ensure a deterministic order of operations.

    c. Run the benchmark with the `driver/benchmark.sh` script.

      * **Inputs:**
        * The query substitution parameters are taken from the value set in `ldbc.snb.interactive.parameters_dir` configuration property.
        * The goal of the benchmark is the achieve the best (lower possible) `time_compression_ratio` value while ensuring that the 95% on-time requirement is kept (i.e. 95% of the queries can be started within 1 second of their scheduled time).
        * Set the `warmup` and `operation_count` values so that the warmup and benchmark phases last for 30+ minutes and 2+ hours, respectively.
      * **Output:** The results of the benchmark are printed to the console and saved in the `results/` directory.
      * **Parallelism:** Multi-threaded execution is recommended to achieve the best result (set `thread_count` accordingly).

For all scripts, configure the parameters file (`driver/${MODE}.properties`) to match your setup and the [scale factor](sf-properties/) of the data set used.

For more details on validating and benchmarking, visit the [driver wiki](https://github.com/ldbc/ldbc_snb_driver/wiki).

## Developer's guide

To create a new implementation, it is recommended to use one of the existing ones: the Neo4j implementation for graph database management systems and the PostgreSQL implementation for RDBMSs.

The implementation process looks roughly as follows:

1. Create a bulk loader which loads the initial data set to the database.

2. Implement the complex and short reads queries (22 in total).

3. Implement the 7 update queries.

4. Test the implementation against the reference implementations using various scale factors.

5. Optimize the implementation.

## Data sets

### Benchmark data sets

To generate the benchmark data sets, use the [Hadoop-based LDBC SNB Datagen](https://github.com/ldbc/ldbc_snb_datagen_hadoop/releases/tag/v0.3.5).

The key configurations are the following:

* `ldbc.snb.datagen.generator.scaleFactor`: set this to `snb.interactive.${SCALE_FACTOR}` where `${SCALE_FACTOR}` is the desired scale factor
* `ldbc.snb.datagen.serializer.numUpdatePartitions`: set this to the number of threads used in the benchmark runs
* serializers: set these to the required format, e.g. the ones starting with `CsvMergeForeign` or `CsvComposite`
  * `ldbc.snb.datagen.serializer.dynamicActivitySerializer`
  * `ldbc.snb.datagen.serializer.dynamicPersonSerializer`
  * `ldbc.snb.datagen.serializer.staticSerializer`

Producing large-scale (SF100+) data sets requires server-grade hardware with 64 GB+ memory and can be time-consuming. To mitigate this, we are working on making these data sets available in a central repository and expect to finish this in Q1 2022. In the meantime, if you require large data sets or update streams with a predefined number of partitions, reach out to the project maintainer, Gabor Szarnyas.

### Test data set

The test data sets are placed in the `${IMPLEMENTATION}/test-data/` directories.

To generate a data set with the same characteristics, see the [documentation on generating the test data set](test-data.md).

## Preparing for an audit

Implementations of the Interactive workload can be audited by a certified LDBC auditor.

### Process

The [Auditing Policies chapter](http://ldbcouncil.org/ldbc_snb_docs/ldbc-snb-specification.pdf#chapter.7) of the specification describes the auditing process and the required artifacts.

### Recommendations

We have a few recommendations for creating audited implementations. However, implementations are allowed to deviate from these:

* The implementation should target a popular Linux distribution (e.g. Ubuntu LTS, Fedora).
* Use a containerized setup, where the DBMS is running in a Docker container.
* Instead of a specific hardware, target a cloud virtual machine instance (e.g. AWS `m5.4xlarge`). Both bare-metal and regular instances can be used for audited runs.
