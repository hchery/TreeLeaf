package org.hchery.treeleaf.db;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

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
public abstract class ImmutableDbModel extends DbModel {
    @Serial
    private static final long serialVersionUID = 1848702131918073483L;

    @CreatedDate
    private Date createTime;
}
