package com.dhtbank.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
@Entity
@Table(name = "tblEmployee")
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID =  1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ten", length = 50, nullable = false)
    private String ten;
    @Column(name = "ma", length = 30, nullable = false, unique = true)
    private String ma;
    @Column(name = "cmt", length = 30, nullable = false)
    private String cmt;
    @Column(name = "ngay_sinh", length = 30, nullable = false)
    private String ngaySinh;
    @Column(name = "dia_chi", length = 30, nullable = false)
    private String diaChi;
    @Column(name = "bac_nghe")
    private int bacNghe;
    @Column(name = "tham_nien", length = 30, nullable = false)
    private int thamNien;
    @Column(name = "vi_tri", length = 30, nullable = false)
    private String viTri;
    @Column(name = "ngay_tao", nullable = false)
    private Date ngayTao;
    @Column(name = "password", nullable = false)
    @Size(min=8, max=16, message = "Ít nhất 8 ký tự và không quá 16 ký tự")
    private String password;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) // quan he 1-n Employee-Customer
    // MapopedBy tro toi ten bien employee o trong Customer.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<Customer> customer;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) // quan he 1-n Employee-TKGui
    // MapopedBy tro toi ten bien employee o trong TKGui.
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Collection<TKGui> tkGuis;
    @PrePersist
    void ngayTao() {
        this.ngayTao = new Date();
    }

}
