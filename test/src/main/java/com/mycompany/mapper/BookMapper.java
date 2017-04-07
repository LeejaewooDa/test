package com.mycompany.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mycompany.vo.Book;
public interface BookMapper {
    @Insert("insert into books (title, author, image) values (#{title}, #{author}, #{image})")
    public boolean create(Book book);
    @Select("select * from books")
    public List<Book> getList();
    @Select("select * from books where id = #{id}")
    public Book getBook(int id);
    @Update("update books set title = #{title}, author = #{author}, image = #{image} where id = #{id}")
    public boolean update(Book book);
    @Delete("delete from books where id = #{id}")
    public boolean delete(int id);
}