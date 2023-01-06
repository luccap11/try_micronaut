package com.example.model;


import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

//@Entity
//@Table(name = "user")
//@Getter
//@Setter
//@ToString
//@RequiredArgsConstructor
//public class UserDto {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @Column(unique = true)
//  private Long id;

//  @Column(nullable = false)
//  private String username = "";

//  @Column(nullable = false)
//  private String password = "";

//  @Override
//  public boolean equals(Object o) {
//      if (this == o) return true;
//      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//      UserDto userDto = (UserDto) o;
//      return id != null && Objects.equals(id, userDto.id);
//  }

//  @Override
//  public int hashCode() {
//      return getClass().hashCode();
//  }
//}
