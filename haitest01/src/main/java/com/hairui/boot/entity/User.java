package com.hairui.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2021-05-19
 */
//lombok

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "u_id", type = IdType.AUTO)
  private Integer uId;

  private LocalDateTime uDate;

  private String uName;

  private String uPassword;

  private String uAddress;

  private String uPhoto;

  private LocalDateTime createTime;
  //设置
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private LocalDateTime updateTime;

  @TableLogic
  private Integer isDeleted;


}
