package com.ssh.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author lt
 * @create 2018-03-31 11:36
 * @VERSION 1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sys_resource_role")
public class SysResourceRoleEntity {

        @Id
        private int id;
        private int resourceId;
        private int roleId;

}
