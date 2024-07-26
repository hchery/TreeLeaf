package org.hchery.treeleaf.db.log;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hchery.treeleaf.db.ImmutableDbModel;
import org.hchery.treeleaf.db.authentication.AuthenticationType;
import org.hchery.treeleaf.db.authentication.LoginErrorType;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serial;
import java.util.Date;

/**
 * DATE: 2024/6/1
 * AUTHOR: hchery
 * URL: https://github.com/hchery
 * EMAIL: h.chery@qq.com
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Document("logs_login")
public class LoginLog extends ImmutableDbModel {
    @Serial
    private static final long serialVersionUID = -4298532843113416357L;

    @Field("user_id")
    private String userId;

    @Field("ip_addr")
    private String ipAddr;

    @Field("ip_region")
    private String ipRegion;

    @Field("user_agent")
    private String userAgent;

    @Field("login_time")
    private Date loginTime;

    @Field("authentication_type")
    private AuthenticationType authenticationType;

    @Field("success")
    private boolean success;

    @Field("error_type")
    private LoginErrorType errorType;
}
