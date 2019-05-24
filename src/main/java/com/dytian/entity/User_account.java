package com.dytian.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 用户通行证
 * </p>
 *
 * @author dytian
 * @since 2018-09-05
 */
@TableName("user_account")
public class User_account extends Model<User_account> {


    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
	@TableId(value="user_id", type= IdType.AUTO)
	private Integer user_id;
    /**
     * 用户帐号
     */
	private String user_account;
    /**
     * 用户手机号
     */
	private String user_phone;
    /**
     * 用户邮箱
     */
	private String user_email;
    /**
     * 用户密码
     */
	private String user_password;
    /**
     * user_salt
     */
	private String user_salt;
    /**
     * 用户名称
     */
	private String user_name;
    /**
     * 用户注册时间
     */
	private Date create_time;
    /**
     * 用户更新时间
     */
	private Date update_time;
    /**
     * 用户类型(供应商:4)
     */
	private Integer user_type;
    /**
     * 用户的开启状态 0为开启 1为关闭
     */
	private Integer user_state;

	public User_account() {
	}

	public Integer getUser_id() {
		return user_id;
	}

	public User_account setUser_id(Integer user_id) {
		this.user_id = user_id;
		return this;
	}

	public String getUser_account() {
		return user_account;
	}

	public User_account setUser_account(String user_account) {
		this.user_account = user_account;
		return this;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public User_account setUser_phone(String user_phone) {
		this.user_phone = user_phone;
		return this;
	}

	public String getUser_email() {
		return user_email;
	}

	public User_account setUser_email(String user_email) {
		this.user_email = user_email;
		return this;
	}

	public String getUser_password() {
		return user_password;
	}

	public User_account setUser_password(String user_password) {
		this.user_password = user_password;
		return this;
	}

	public String getUser_salt() {
		return user_salt;
	}

	public User_account setUser_salt(String user_salt) {
		this.user_salt = user_salt;
		return this;
	}

	public String getUser_name() {
		return user_name;
	}

	public User_account setUser_name(String user_name) {
		this.user_name = user_name;
		return this;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public User_account setCreate_time(Date create_time) {
		this.create_time = create_time;
		return this;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public User_account setUpdate_time(Date update_time) {
		this.update_time = update_time;
		return this;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public User_account setUser_type(Integer user_type) {
		this.user_type = user_type;
		return this;
	}

	public Integer getUser_state() {
		return user_state;
	}

	public User_account setUser_state(Integer user_state) {
		this.user_state = user_state;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.user_id;
	}

	@Override
	public String toString() {
		return "User_account{" +
			"user_id=" + user_id +
			", user_account=" + user_account +
			", user_phone=" + user_phone +
			", user_email=" + user_email +
			", user_password=" + user_password +
			", user_salt=" + user_salt +
			", user_name=" + user_name +
			", create_time=" + create_time +
			", update_time=" + update_time +
			", user_type=" + user_type +
			", user_state=" + user_state +
			"}";
	}
}
