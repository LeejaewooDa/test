package com.mycompany.myapp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.helper.FileHelper;
import com.mycompany.helper.URLHelper;
import com.mycompany.mapper.BookMapper;
import com.mycompany.mapper.ReviewMapper;
import com.mycompany.vo.Book;
import com.mycompany.vo.Review;
@Controller
public class BooksController {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private ReviewMapper reviewMapper;
  
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String index(Model model) {
        List<Book> books = bookMapper.getList();
        // 모델을 통해 뷰페이지로 데이터를 전달
        model.addAttribute("books", books);
        return "books/index";
    }
    
    @RequestMapping(value = "/books/new", method = RequestMethod.GET)
    
    public String newBook() {
        return "books/new";
    }
    
   
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String create(@ModelAttribute Book book, @RequestParam MultipartFile file, HttpServletRequest request) {
        String fileUrl = FileHelper.upload("/uploads", file, request);
        book.setImage(fileUrl);
        bookMapper.create(book);
        return "redirect: " + URLHelper.baseUrl("/books", request);
    }
    @RequestMapping(value = "/books/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, HttpServletRequest request) {
        bookMapper.delete(id);
        return "redirect: " + request.getContextPath() + "/books";
    }
    @RequestMapping(value = "/books/edit/{id}", method = RequestMethod.GET)
    

    public String edit(@PathVariable int id, Model model) {
        Book book = bookMapper.getBook(id);
        // 뷰 페이지로 데이터를 전달(key/value 형식)
        model.addAttribute("book", book);
        return "books/edit";
    }

   
 
    @RequestMapping(value = "/books/update", method = RequestMethod.POST)
    public String update(@ModelAttribute Book book,  HttpServletRequest request) {
        bookMapper.update(book);
        return "redirect: " + request.getContextPath() + "/books";
    }
    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, Model model) {
        Book book = bookMapper.getBook(id);
        model.addAttribute("book", book);
        // 등록된 리뷰들
        List<Review> reviews = reviewMapper.getReviews(id);
        model.addAttribute("reviews", reviews);
        // 새로운 리뷰 등록
        Review review = new Review();
        review.setBookId(id);
        model.addAttribute("review", review);
        return "books/show";
    }
}