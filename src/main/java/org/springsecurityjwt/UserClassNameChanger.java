package org.springsecurityjwt;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Configuration;

/**
 * Author: ykhatri
 * Date: 29-11-2019
 */
@Configuration
public class UserClassNameChanger extends SpringPhysicalNamingStrategy {

    @Value("${user.tablename}")
    private String tableName;
    @Value("${user.password}")
    private String password;
    @Value("${user.username}")
    private String username;

    public static final String DEFAULT_TABLE = "ee11cbb19052e40b07aac0ca060c23ee";
    public static final String DEFAULT_USERNAME = "14c4b06b824ec593239362517f538b29";
    public static final String DEFAULT_PASSWORD = "5f4dcc3b5aa765d61d8327deb882cf99";


    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
       if(name.getText().equals(DEFAULT_TABLE))
           return new Identifier(tableName,name.isQuoted());
       return new Identifier(name.getText(),name.isQuoted());
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if(name.getText().equals(DEFAULT_USERNAME))
            return new Identifier(username,name.isQuoted());
        if(name.getText().equals(DEFAULT_PASSWORD))
            return new Identifier(password,name.isQuoted());
        return new Identifier(name.getText(),name.isQuoted());
    }
}
