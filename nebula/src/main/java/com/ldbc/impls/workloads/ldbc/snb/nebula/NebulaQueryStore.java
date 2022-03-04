package com.ldbc.impls.workloads.ldbc.snb.nebula;

import com.google.common.collect.ImmutableMap;
import com.ldbc.driver.DbException;
import com.ldbc.driver.workloads.ldbc.snb.interactive.*;
import com.ldbc.impls.workloads.ldbc.snb.QueryStore;
import com.ldbc.impls.workloads.ldbc.snb.converter.Converter;
import com.ldbc.impls.workloads.ldbc.snb.nebula.converter.NebulaConverter;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class NebulaQueryStore extends QueryStore {
    public static final String COMMENT_ID = "commentId";

    public NebulaQueryStore(String path) throws DbException  {
        super(path, ".ngql");
    }

    @Override
    public Converter getConverter() {
        return new NebulaConverter();
    }

    @Override
    public String getQuery1(LdbcQuery1 operation) {
        return prepare(QueryType.InteractiveComplexQuery1, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("firstName", getConverter().convertString(operation.firstName()))
                .build());
    }

    public String getQuery2(LdbcQuery2 operation) {
        return prepare(QueryType.InteractiveComplexQuery2, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("maxDate", getConverter().convertDateTime(operation.maxDate()))
                .build());
    }

    protected Date addDays(Date startDate, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    @Override
    public String getQuery3(LdbcQuery3 operation) {
        Date endDate = addDays(operation.startDate(), operation.durationDays());
        return prepare(QueryType.InteractiveComplexQuery3, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("countryXName", getConverter().convertString(operation.countryXName()))
                .put("countryYName", getConverter().convertString(operation.countryYName()))
                .put("startDate", getConverter().convertDateTime(operation.startDate()))
                .put("endDate", getConverter().convertDateTime(endDate))
                .build());
    }

    @Override
    public String getQuery4(LdbcQuery4 operation) {
        Date endDate = addDays(operation.startDate(), operation.durationDays());
        return prepare(QueryType.InteractiveComplexQuery4, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("startDate", getConverter().convertDateTime(operation.startDate()))
                .put("endDate", getConverter().convertDateTime(endDate))
                .build());
    }

    @Override
    public String getQuery5(LdbcQuery5 operation) {
        return prepare(QueryType.InteractiveComplexQuery5, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("minDate", getConverter().convertDateTime(operation.minDate()))
                .build());
    }

    @Override
    public String getQuery6(LdbcQuery6 operation) {
        return prepare(QueryType.InteractiveComplexQuery6, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("tagName", getConverter().convertString(operation.tagName()))
                .build());
    }

    @Override
    public String getQuery7(LdbcQuery7 operation) {
        return prepare(QueryType.InteractiveComplexQuery7, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .build());
    }


    @Override
    public String getQuery8(LdbcQuery8 operation) {
        return prepare(QueryType.InteractiveComplexQuery8, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .build());
    }

    @Override
    public String getQuery9(LdbcQuery9 operation) {
        return prepare(QueryType.InteractiveComplexQuery9, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("maxDate", getConverter().convertDateTime(operation.maxDate()))
                .build());
    }

    @Override
    public String getQuery10(LdbcQuery10 operation) {
        return prepare(QueryType.InteractiveComplexQuery10, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("month", getConverter().convertInteger(operation.month()))
                .put("nextMonth", getConverter().convertInteger(operation.month() % 12 + 1))
                .build());
    }

    @Override
    public String getQuery11(LdbcQuery11 operation) {
        return prepare(QueryType.InteractiveComplexQuery11, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("countryName", getConverter().convertString(operation.countryName()))
                .put("workFromYear", getConverter().convertInteger(operation.workFromYear()))
                .build());
    }

    @Override
    public String getQuery12(LdbcQuery12 operation) {
        return prepare(QueryType.InteractiveComplexQuery12, new ImmutableMap.Builder<String, String>()
                .put("personId", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
                .put("tagClassName", getConverter().convertString(operation.tagClassName()))
                .build());
    }

    @Override
    public String getQuery13(LdbcQuery13 operation) {
        return prepare(QueryType.InteractiveComplexQuery13, new ImmutableMap.Builder<String, String>()
                .put("person1Id", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person1Id())))
                .put("person2Id", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person2Id())))
                .build());
    }

    @Override
    public String getQuery14(LdbcQuery14 operation) {
        return prepare(QueryType.InteractiveComplexQuery14, new ImmutableMap.Builder<String, String>()
                .put("person1Id", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person1Id())))
                .put("person2Id", getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person2Id())))
                .build());
    }

    // Interactive short reads

    @Override
    public String getShortQuery1PersonProfile(LdbcShortQuery1PersonProfile operation) {
        return prepare(
                QueryType.InteractiveShortQuery1,
                ImmutableMap.of(
                        LdbcShortQuery1PersonProfile.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
        );
    }


    @Override
    public String getShortQuery2PersonPosts(LdbcShortQuery2PersonPosts operation) {
        return prepare(
                QueryType.InteractiveShortQuery2,
                ImmutableMap.of(LdbcShortQuery2PersonPosts.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
        );
    }

    @Override
    public String getShortQuery3PersonFriends(LdbcShortQuery3PersonFriends operation) {
        return prepare(
                QueryType.InteractiveShortQuery3,
                ImmutableMap.of(LdbcShortQuery3PersonFriends.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())))
        );
    }

    @Override
    public String getShortQuery4MessageContent(LdbcShortQuery4MessageContent operation) {
        return prepare(
                QueryType.InteractiveShortQuery4,
                ImmutableMap.of(COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertId(operation.messageId())),
                        "postId", getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertId(operation.messageId())))
        );
    }

    @Override
    public String getShortQuery5MessageCreator(LdbcShortQuery5MessageCreator operation) {
        return prepare(
                QueryType.InteractiveShortQuery5,
                ImmutableMap.of(COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertId(operation.messageId())),
                                "postId", getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertId(operation.messageId())))
        );
    }

    @Override
    public String getShortQuery6MessageForum(LdbcShortQuery6MessageForum operation) {
        return prepare(
                QueryType.InteractiveShortQuery6,
                ImmutableMap.of(COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertId(operation.messageId())),
                        "postId", getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertId(operation.messageId())))
        );
    }

    @Override
    public String getShortQuery7MessageReplies(LdbcShortQuery7MessageReplies operation) {
        return prepare(
                QueryType.InteractiveShortQuery7,
                ImmutableMap.of(COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertId(operation.messageId())),
                        "postId", getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertId(operation.messageId())))
        );
    }

    @Override
    public String getUpdate2(LdbcUpdate2AddPostLike operation) {
        return prepare(
                QueryType.InteractiveUpdate2,
                ImmutableMap.of(
                        LdbcUpdate2AddPostLike.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())),
                        LdbcUpdate2AddPostLike.POST_ID, getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertId(operation.postId())),
                        LdbcUpdate2AddPostLike.CREATION_DATE, getConverter().convertDateTime(operation.creationDate())
                )
        );
    }

    @Override
    public String getUpdate3(LdbcUpdate3AddCommentLike operation) {
        return prepare(
                QueryType.InteractiveUpdate3,
                ImmutableMap.of(
                        LdbcUpdate3AddCommentLike.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())),
                        LdbcUpdate3AddCommentLike.COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertId(operation.commentId())),
                        LdbcUpdate3AddCommentLike.CREATION_DATE, getConverter().convertDateTime(operation.creationDate())
                )
        );
    }

    @Override
    public String getUpdate5(LdbcUpdate5AddForumMembership operation) {
        return prepare(
                QueryType.InteractiveUpdate5,
                ImmutableMap.of(
                        LdbcUpdate5AddForumMembership.FORUM_ID, getConverter().convertString(NebulaID.FORUM_ID_PREFIX + getConverter().convertId(operation.forumId())),
                        LdbcUpdate5AddForumMembership.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.personId())),
                        LdbcUpdate5AddForumMembership.JOIN_DATE, getConverter().convertDateTime(operation.joinDate())
                )
        );
    }

    @Override
    public String getUpdate8(LdbcUpdate8AddFriendship operation) {
        return prepare(
                QueryType.InteractiveUpdate8,
                ImmutableMap.of(
                        LdbcUpdate8AddFriendship.PERSON1_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person1Id())),
                        LdbcUpdate8AddFriendship.PERSON2_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertId(operation.person2Id())),
                        LdbcUpdate8AddFriendship.CREATION_DATE, getConverter().convertDateTime(operation.creationDate())
                )
        );
    }

    // multiple
    @Override
    public List<String> getUpdate1Multiple(LdbcUpdate1AddPerson operation) {
        List<String> list = new ArrayList<>();
        list.add(prepare(
                QueryType.InteractiveUpdate1AddPerson,
                new ImmutableMap.Builder<String, String>()
                        .put(LdbcUpdate1AddPerson.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertIdForInsertion(operation.personId())))
                        .put(LdbcUpdate1AddPerson.PERSON_FIRST_NAME, getConverter().convertString(operation.personFirstName()))
                        .put(LdbcUpdate1AddPerson.PERSON_LAST_NAME, getConverter().convertString(operation.personLastName()))
                        .put(LdbcUpdate1AddPerson.GENDER, getConverter().convertString(operation.gender()))
                        .put(LdbcUpdate1AddPerson.BIRTHDAY, getConverter().convertDate(operation.birthday()))
                        .put(LdbcUpdate1AddPerson.CREATION_DATE, getConverter().convertDateTime(operation.creationDate()))
                        .put(LdbcUpdate1AddPerson.LOCATION_IP, getConverter().convertString(operation.locationIp()))
                        .put(LdbcUpdate1AddPerson.BROWSER_USED, getConverter().convertString(operation.browserUsed()))
                        .build()
        ));

        for (LdbcUpdate1AddPerson.Organization organization : operation.workAt()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate1AddPersonCompanies,
                    ImmutableMap.of(
                            LdbcUpdate1AddPerson.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertIdForInsertion(operation.personId())),
                            "organizationId", getConverter().convertString(NebulaID.ORGANISATION_ID_PREFIX + getConverter().convertId(organization.organizationId())),
                            "worksFromYear", getConverter().convertInteger(organization.year())
                    )
            ));
        }

        for (long tagId : operation.tagIds()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate1AddPersonTags,
                    ImmutableMap.of(
                            LdbcUpdate1AddPerson.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertIdForInsertion(operation.personId())),
                            "tagId", getConverter().convertString(NebulaID.TAG_ID_PREFIX + getConverter().convertId(tagId)))
                    )
            );
        }
        for (LdbcUpdate1AddPerson.Organization organization : operation.studyAt()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate1AddPersonUniversities,
                    ImmutableMap.of(
                            LdbcUpdate1AddPerson.PERSON_ID, getConverter().convertString(NebulaID.PERSON_ID_PREFIX + getConverter().convertIdForInsertion(operation.personId())),
                            "organizationId", getConverter().convertString(NebulaID.ORGANISATION_ID_PREFIX + getConverter().convertId(organization.organizationId())),
                            "studiesFromYear", getConverter().convertInteger(organization.year())
                    )
            ));
        }
        return list;
    }

    @Override
    public List<String> getUpdate4Multiple(LdbcUpdate4AddForum operation) {
        List<String> list = new ArrayList<>();
        list.add(prepare(
                QueryType.InteractiveUpdate4AddForum,
                ImmutableMap.of(
                        LdbcUpdate4AddForum.FORUM_ID, getConverter().convertString(NebulaID.FORUM_ID_PREFIX + getConverter().convertIdForInsertion(operation.forumId())),
                        LdbcUpdate4AddForum.FORUM_TITLE, getConverter().convertString(operation.forumTitle()),
                        LdbcUpdate4AddForum.CREATION_DATE, getConverter().convertDateTime(operation.creationDate())
                )
        ));

        for (long tagId : operation.tagIds()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate4AddForumTags,
                    ImmutableMap.of(
                            LdbcUpdate4AddForum.FORUM_ID, getConverter().convertString(NebulaID.FORUM_ID_PREFIX + getConverter().convertIdForInsertion(operation.forumId())),
                            "tagId", getConverter().convertString(NebulaID.TAG_ID_PREFIX + getConverter().convertId(tagId)))
                    )
            );
        }
        return list;
    }

    @Override
    public List<String> getUpdate6Multiple(LdbcUpdate6AddPost operation) {
        List<String> list = new ArrayList<>();
        list.add(prepare(
                QueryType.InteractiveUpdate6AddPost,
                new ImmutableMap.Builder<String, String>()
                        .put(LdbcUpdate6AddPost.POST_ID, getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertIdForInsertion(operation.postId())))
                        .put(LdbcUpdate6AddPost.IMAGE_FILE, getConverter().convertString(operation.imageFile()))
                        .put(LdbcUpdate6AddPost.CREATION_DATE, getConverter().convertDateTime(operation.creationDate()))
                        .put(LdbcUpdate6AddPost.LOCATION_IP, getConverter().convertString(operation.locationIp()))
                        .put(LdbcUpdate6AddPost.BROWSER_USED, getConverter().convertString(operation.browserUsed()))
                        .put(LdbcUpdate6AddPost.LANGUAGE, getConverter().convertString(operation.language()))
                        .put(LdbcUpdate6AddPost.CONTENT, getConverter().convertString(operation.content()))
                        .put(LdbcUpdate6AddPost.LENGTH, getConverter().convertInteger(operation.length()))
                        .build()
                )
        );
        for (long tagId : operation.tagIds()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate6AddPostTags,
                    ImmutableMap.of(
                            LdbcUpdate6AddPost.POST_ID, getConverter().convertString(NebulaID.POST_ID_PREFIX + getConverter().convertIdForInsertion(operation.postId())),
                            "tagId", getConverter().convertString(NebulaID.TAG_ID_PREFIX + getConverter().convertId(tagId)))
                    )
            );
        }
        return list;
    }

    @Override
    public List<String> getUpdate7Multiple(LdbcUpdate7AddComment operation) {
        List<String> list = new ArrayList<>();
        list.add(prepare(
                QueryType.InteractiveUpdate7AddComment,
                new ImmutableMap.Builder<String, String>()
                        .put(LdbcUpdate7AddComment.COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertIdForInsertion(operation.commentId())))
                        .put(LdbcUpdate7AddComment.CREATION_DATE, getConverter().convertDateTime(operation.creationDate()))
                        .put(LdbcUpdate7AddComment.LOCATION_IP, getConverter().convertString(operation.locationIp()))
                        .put(LdbcUpdate7AddComment.BROWSER_USED, getConverter().convertString(operation.browserUsed()))
                        .put(LdbcUpdate7AddComment.CONTENT, getConverter().convertString(operation.content()))
                        .put(LdbcUpdate7AddComment.LENGTH, getConverter().convertInteger(operation.length()))
                        .build()
        ));
        for (long tagId : operation.tagIds()) {
            list.add(prepare(
                    QueryType.InteractiveUpdate7AddCommentTags,
                    ImmutableMap.of(
                            LdbcUpdate7AddComment.COMMENT_ID, getConverter().convertString(NebulaID.COMMENT_ID_PREFIX + getConverter().convertIdForInsertion(operation.commentId())),
                            "tagId", getConverter().convertString(NebulaID.TAG_ID_PREFIX + getConverter().convertId(tagId)))
                    )
            );
        }
        return list;
    }

}
