package com.cyx.spring._23_spring_jdbc_crud.service.impl;

import com.cyx.spring._23_spring_jdbc_crud.domain.User;
import com.cyx.spring._23_spring_jdbc_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /* Spring 不建议使用注解的方式注入 JdbcTemplate 对象，因此我们可以在 setJdbcTemplate 方法上注入依赖 */
    // JdbcTemplate 类，Spring JDBC 操作的模板类，在该类中包含了大量增删改查的功能
    private JdbcTemplate jdbcTemplate;

    // NamedParameterJdbcTemplate 类，命名的参数 JDBC 操作模板类，其实包含了 JdbcTemplate
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    // 注入 DataSource 实例并创建 JdbcTemplate 实例
    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);

        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void saveUser(User user) {
        jdbcTemplate.update("INSERT INTO user (account, password) VALUES (?, ?)",
                user.getAccount(), user.getPassword());
    }

    @Override
    public void updateUser(User user) {
        jdbcTemplate.update("UPDATE user SET account = ?, password = ? WHERE id = ?",
                user.getAccount(), user.getPassword(), user.getId());

        // 该参数占位符其名称
        namedParameterJdbcTemplate.update("UPDATE user SET account = :account, password = :password WHERE id = :id",
                new HashMap<String, Object>() {{
                    this.put("account", user.getAccount());
                    this.put("password", user.getPassword());
                    this.put("id", user.getId());
                }});
    }

    @Override
    public void deleteUser(Long id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);
    }

    @Override
    public User getUserById(Long id) {
        // 使用 jdbcTemplate 类中的 queryForObject 方法，查询单个数据：
        return jdbcTemplate.queryForObject(
                "SELECT u.id, u.account, u.password FROM user u WHERE u.id = ?",
                new Object[]{id},
                (rs, rowNum) -> new User(rs.getLong("id"), rs.getString("account"), rs.getString("password")));
        /*
            注意：该方式有一个问题，当我们没有查询到数据的时候，该方法会报错，也就是该方法返回不能为空。
            解决方法：使用 JdbcTemplate.query 查询多条数据的方法，若果返回的集合条数为 1，则返回第一条数据，否则返回 null。
        */
    }

    @Override
    public List<User> getUserList() {
        /*
            这里使用 RowMapper 接口的实现类 BeanPropertyRowMapper 类帮我们完成 Bean 对象的属性注入。
            注意：使用 BeanPropertyRowMapper 类要保证需要转换的 Bean 中有无参构造方法。
        */
        return jdbcTemplate.query(
                "SELECT u.id, u.account, u.password FROM user u",
                new BeanPropertyRowMapper<>(User.class));
        /*
            查看 BeanPropertyRowMapper 类中的源码可以发现，该类使用内省帮我们完成了字段 -> 属性的映射工作。
        */
    }
}
