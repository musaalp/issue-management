package com.malp.issuemanagement.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

// @Data // generate getter and setter behind
@Getter // generate getter behind for each prop
@Setter // generate setter behind for each prop
@MappedSuperclass //
public abstract class BaseEntity implements Serializable {

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @Column(name = "status")
    private Boolean status;
}
