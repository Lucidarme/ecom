/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lucidarme.api.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lucidarme
 */
@Entity
@Table(name = "evenements")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evenements.findAll", query = "SELECT e FROM Evenements e")
    , @NamedQuery(name = "Evenements.findById", query = "SELECT e FROM Evenements e WHERE e.id = :id")
    , @NamedQuery(name = "Evenements.findByName", query = "SELECT e FROM Evenements e WHERE e.name = :name")
    , @NamedQuery(name = "Evenements.findByPrice", query = "SELECT e FROM Evenements e WHERE e.price = :price")
    , @NamedQuery(name = "Evenements.findByType", query = "SELECT e FROM Evenements e WHERE e.type = :type")
    , @NamedQuery(name = "Evenements.findByDate", query = "SELECT e FROM Evenements e WHERE e.date = :date")})
public class Evenements implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Short id;
    @Size(max = 40)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "price")
    private String price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imageLink")
    private String imageLink;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Evenements() {
    }

    public Evenements(Short id) {
        this.id = id;
    }

    public Evenements(Short id, String price, String type, String imageLink, String description) {
        this.id = id;
        this.price = price;
        this.type = type;
        this.imageLink = imageLink;
        this.description = description;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenements)) {
            return false;
        }
        Evenements other = (Evenements) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Evenements[ id=" + id + " ]";
    }
    
}
