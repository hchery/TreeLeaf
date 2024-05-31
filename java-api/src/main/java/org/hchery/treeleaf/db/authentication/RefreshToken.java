package org.hchery.treeleaf.db.authentication;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hchery.treeleaf.db.MutableDbModel;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/5/28
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Document("refresh_token")
public class RefreshToken extends MutableDbModel {
    @Serial
    private static final long serialVersionUID = -342840025797276322L;

    @Field("user_id")
    private String userId;

    @Field("expire_time")
    private Date expireTime;

    @Field("logout")
    private boolean logout;

    @Field("disabled")
    private boolean disabled;

    @Field("illegal")
    private boolean illegal;
}
