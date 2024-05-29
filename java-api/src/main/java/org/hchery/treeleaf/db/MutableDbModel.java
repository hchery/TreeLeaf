package org.hchery.treeleaf.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/5/14
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public abstract class MutableDbModel extends ImmutableDbModel {
    @Serial
    private static final long serialVersionUID = -8126447441783658508L;

    @LastModifiedDate
    @Field("update_time")
    private Date updateTime;
}
