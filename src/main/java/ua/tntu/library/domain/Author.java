package ua.tntu.library.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(catalog = "library")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fio;

    private Date birthday;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "author")
    private List<Book> books;

}
