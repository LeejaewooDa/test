package com.mycompany.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mycompany.vo.Review;

public interface ReviewMapper {
    @Insert("INSERT INTO reviews (text, book_id) "
            +"VALUES (#{text}, #{bookId})")
    void create(Review review);
    @Select("SELECT * "
            + "FROM reviews "
            + "WHERE book_id = #{bookId} "
            + "ORDER BY id DESC")
    List<Review> getReviews(int bookId);
}