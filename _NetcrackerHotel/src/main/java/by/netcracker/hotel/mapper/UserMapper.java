package by.netcracker.hotel.mapper;

import by.netcracker.hotel.dao.constant.ColumnName;
import by.netcracker.hotel.entities.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by slava on 10.04.17.
 */
public class UserMapper implements RowMapper {
    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        User user = new User();
        int currentID  = resultSet.getInt(1);
        do {
            if(currentID != resultSet.getInt(1)){
                resultSet.previous();
                break;
            }
            switch (resultSet.getString(2)) {
                case ColumnName.USER_FIRST_NAME: {
                    user.setFirstName(resultSet.getString(3));
                    break;
                }
                case ColumnName.USER_LAST_NAME: {
                    user.setLastName(resultSet.getString(3));
                    break;
                }
                case ColumnName.USER_USERNAME: {
                    user.setUsername(resultSet.getString(3));
                    break;
                }
                case ColumnName.USER_EMAIL: {
                    user.setEmail(resultSet.getString(3));
                    break;
                }
                case ColumnName.USER_PASSWORD: {
                    user.setPassword(resultSet.getString(3));
                    break;
                }
                case ColumnName.USER_ACCESS_LEVEL: {
                    user.setAccessLevel(Integer.parseInt(resultSet.getString(3)));
                    break;
                }
                case ColumnName.USER_ENABLED :{
                    user.setEnabled(Boolean.parseBoolean(resultSet.getString(3)));
                    break;
                }
                case ColumnName.USER_AUTHORITY :{
                    user.setAuthority(resultSet.getString(3));
                    break;
                }
            }
        } while (resultSet.next());
        return user;
    }
}
