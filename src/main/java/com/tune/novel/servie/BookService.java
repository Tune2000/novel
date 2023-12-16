package com.tune.novel.servie;

import com.tune.novel.core.common.resp.RestResp;
import com.tune.novel.model.dto.resp.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * @author Tune
 * @create 2023-12-12-23:02
 * @description: 小说模块 服务类
 */
public interface BookService {
    /**
     * 小说信息查询
     *
     * @param bookId 小说ID
     * @return 小说信息
     */
    RestResp<BookInfoRespDto> getBookById(Long bookId);

    /**
     * 小说推荐列表查询
     *
     * @param bookId 小说ID
     * @return 小说信息列表
     */
    RestResp<List<BookInfoRespDto>> listRecBooks(Long bookId) throws NoSuchAlgorithmException;

    /**
     * 小说最新章节相关信息查询
     *
     * @param bookId 小说ID
     * @return 章节相关联的信息
     */
    RestResp<BookChapterAboutRespDto> getLastChapterAbout(Long bookId);

    /**
     * 小说最新评论查询
     *
     * @param bookId 小说ID
     * @return 小说最新评论数据
     */
    RestResp<BookCommentRespDto> listNewestComments(Long bookId);

    /**
     * 小说点击榜查询
     *
     * @return 小说点击排行列表
     */
    RestResp<List<BookRankRespDto>> listVisitRankBooks();

    /**
     * 小说新书榜查询
     *
     * @return 小说新书排行列表
     */
    RestResp<List<BookRankRespDto>> listNewestRankBooks();

    /**
     * 小说更新榜查询
     *
     * @return 小说更新排行列表
     */
    RestResp<List<BookRankRespDto>> listUpdateRankBooks();

    /**
     * 发表评论
     *
     * @param dto 评论相关 DTO
     * @return void
     */
    RestResp<Void> saveComment(UserCommentReqDto dto);

    /**
     * 修改评论
     *
     * @param userId  用户ID
     * @param id      评论ID
     * @param content 修改后的评论内容
     * @return void
     */
    RestResp<Void> updateComment(Long userId, Long id, String content);

    /**
     * 删除评论
     *
     * @param userId    评论用户ID
     * @param commentId 评论ID
     * @return void
     */
    RestResp<Void> deleteComment(Long userId, Long commentId);
}
