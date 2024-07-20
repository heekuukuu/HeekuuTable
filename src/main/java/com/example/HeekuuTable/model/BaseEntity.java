package com.example.HeekuuTable.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

public class BaseEntity {
 @Getter
 @MappedSuperclass
 @EntityListeners(value = {AuditingEntityListener.class})

    @CreatedDate
    private LocalDateTime cratedAt; //생성된날짜

    @LastModifiedDate
    private LocalDateTime modifiedAt; //수정된날짜

}