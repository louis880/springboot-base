package com.business.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author LUJIAWEI931
 * @since 2019-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("T_SYS_CODE")
@ApiModel(value = "TSysCode对象", description = "")
public class TSysCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private Long id;

    @TableField("CODE_CATEGORY")
    private String codeCategory;

    @TableField("CODE")
    private String code;

    @TableField("CONTENT_LANG1")
    private String contentLang1;

    @TableField("CONTENT_LANG2")
    private String contentLang2;

    @TableField("CONTENT_LANG3")
    private String contentLang3;

    @TableField("SORTNUM")
    private Double sortnum;


}
