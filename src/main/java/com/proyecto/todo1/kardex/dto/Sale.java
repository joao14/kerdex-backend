package com.proyecto.todo1.kardex.dto;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sale")
@XmlRootElement
public class Sale {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sale")
    private Integer id_sale;
    @Basic(optional = false)
    @Column(name = "identification")
    private String identification;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "mail")
    private String mail;
    @Column(name = "phone")
    private String phone;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne
    private Product id;

    public Sale() {
    }

    public Sale(String identification, String name, String mail, String phone, Product id) {
        this.identification = identification;
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.id = id;
    }

    public Integer getId_sale() {
        return id_sale;
    }

    public void setId_sale(Integer id_sale) {
        this.id_sale = id_sale;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Product getId() {
        return id;
    }

    public void setId(Product id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_sale != null ? id_sale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.id_sale == null && other.id_sale != null) || (this.id_sale != null && !this.id_sale.equals(other.id_sale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Sale[ id_sale=" + id_sale + " ]";
    }
}
