package com.melon.sx.study.dao;

import com.melon.sx.study.domain.SensitiveWordDomain;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * 敏感词DAO
 *
 * @author imelonkid
 * @date 2021/09/17 21:36
 **/
@Repository
public class SensitiveWordDao extends AbstractDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(SensitiveWordDomain sensitiveWordDomain) {
        jdbcTemplate.update(generateInsert(sensitiveWordDomain),
            sensitiveWordDomain.getId(), sensitiveWordDomain.getWord(),
            sensitiveWordDomain.getMsg());
    }

    public SensitiveWordDomain findByWord(String word) {
        return jdbcTemplate.queryForObject(
            "SELECT id, word, msg FROM m_sensitive_words where word = ?", new Object[]{word},
            (rs, num) -> {
                SensitiveWordDomain wordDomain = new SensitiveWordDomain();
                wordDomain.setId(rs.getInt("id"));
                wordDomain.setMsg(rs.getString("msg"));
                wordDomain.setWord(rs.getString("word"));
                return wordDomain;
            });

    }

    @Override
    public String getTableName() {
        return "m_sensitive_words";
    }
}
