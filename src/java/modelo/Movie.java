/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**
 *
 * @author ASUS
 */
public class Movie {

    private Long id;

    private String title;
    private String slug;
    private String description;
    private Long year;
    private String type;
    private String status;
    private String category;
    private String imageUrl;
    private Boolean carousel;
    private BigDecimal rating;
    private Long duration;
    private OffsetDateTime createdAt;

    public Movie() {
    }

    public Movie(Long id, String title, String slug, String description, Long year, String type, String status, String category, String imageUrl, Boolean carousel, BigDecimal rating, Long duration, OffsetDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.year = year;
        this.type = type;
        this.status = status;
        this.category = category;
        this.imageUrl = imageUrl;
        this.carousel = carousel;
        this.rating = rating;
        this.duration = duration;
        this.createdAt = createdAt;
    }  

    public Movie(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }
    
    
    
    public Movie(String title, String slug, String description, Long year, String type, String status, String category,
             String imageUrl, Boolean carousel, BigDecimal rating, Long duration) {
        this.title = title;
        this.slug = slug;
        this.description = description;
        this.year = year;
        this.type = type;
        this.status = status;
        this.category = category;
        this.imageUrl = imageUrl;
        this.carousel = carousel;
        this.rating = rating;
        this.duration = duration;
}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getCarousel() {
        return carousel;
    }

    public void setCarousel(Boolean carousel) {
        this.carousel = carousel;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    @Override
    public String toString() {
        return "Movie {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", slug='" + slug + '\'' +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", carousel='" + carousel + '\'' +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
    
}
