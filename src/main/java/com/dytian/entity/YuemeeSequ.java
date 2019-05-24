package com.dytian.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;


/**
 * <p>
 * 自增ID
 * </p>
 *
 * @author dytian
 * @since 2019-05-20
 */
public class YuemeeSequ extends Model<YuemeeSequ> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 标题
     */
	private String sub_ip;


	public Long getId() {
		return id;
	}


	public YuemeeSequ setId(Long id) {
		this.id = id;
		return this;
	}

	public String getSub_ip() {
		return sub_ip;
	}


	public YuemeeSequ setSub_ip(String sub_ip) {
		this.sub_ip = sub_ip;
		return this;
	}

	public static final String ID = "id";

	public static final String SUB_IP = "sub_ip";


	@Override
	public String toString() {
		return "YuemeeSequ{" +
			"id=" + id +
			", sub_ip=" + sub_ip +
			"}";
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
