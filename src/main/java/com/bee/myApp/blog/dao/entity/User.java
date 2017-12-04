/* @()User.java
 *
 * (c) COPYRIGHT 2009-2013 Bee INC. All rights reserved.
 * Bee CONFIDENTIAL PROPRIETARY
 * Bee Advanced Technology and Software Operations
 *
 * REVISION HISTORY:
 * Author             Date                   Brief Description
 * -----------------  ----------     ---------------------------------------
 * Linfeng            下午3:50:04                init version
 * 
 */
package com.bee.myApp.blog.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <pre>
 * CLASS:
 * Describe class, extends and implements relationships to other classes.
 * 
 * RESPONSIBILITIES:
 * High level list of things that the class does
 * -) 
 * 
 * COLABORATORS:
 * List of descriptions of relationships with other classes, i.e. uses, contains, creates, calls...
 * -) class   relationship
 * -) class   relationship
 * 
 * USAGE:
 * Description of typical usage of class.  Include code samples.
 * 
 * 
 **/
public class User implements Serializable {

	private String name;
	private String age;
	private Date createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public User() {
		super();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public User(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}

}
