package com.jay.redis.service;


import java.util.List;

public interface RedisService {

    /**
     * 点赞，状态为1
     * @param likeUserId
     * @param likedPostId
     */
    void saveLiked2Redis(String likeUserId,String likedPostId);

    /**
     * 取消点赞，状态为0
     * @param likedUserId
     * @param likedPostId
     */
    void unlikedFromRedis(String likedUserId,String likedPostId);

    /**
     * 从redis中删除一条点赞数据
     * @param likedUserId
     * @param likedPostId
     */
    void deleteLikedFromRedis(String likedUserId,String likedPostId);

    /**
     * 该用户的点赞数减1
     * @param likedUserId
     */
    void incrementLikedCount(String likedUserId);
//
//    /**
//     * 获取Redis中存储的所有点赞数
//     * @return
//     */
//    List<UserLike> getLikedDataFromRedis();
}
