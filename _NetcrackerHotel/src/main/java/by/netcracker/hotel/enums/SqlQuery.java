package by.netcracker.hotel.enums;

import java.util.ResourceBundle;

import javax.validation.constraints.NotNull;

/**
 * Created by slava on 02.04.17.
 */
public enum SqlQuery {
    ADD_ENTITY_ID, ADD_USER, GET_BY, GET_BY_ID, ADD_REVIEW,
    GET_ALL, SEARCH_HOTEL, GET_PLACES, DELETE_BY_ID, DELETE_BY,
    UPDATE, ADD_TOKEN, ADD_HOTEL, ADD_PHOTO, GET_PHOTOS_FOR_HOTEL, 
    GET_MAIN_PHOTO_FOR_HOTEL, SET_MAIN_PHOTO_FOR_HOTEL, CHECK_REVIEW,
    ADD_ORDER, ADD_ROOM, GET_ROOMS_BY_HOTEL_ID, GET_USERS, GET_USERNAMES, GET_HOTEL_NAMES,
    SORTED_PAGINATION, ADD_FILTER, ALL_PAGINATION, AFTER_ALL_PART, AFTER_SORTED_PART,
    GET_FREE_ROOMS_IN_HOTEL_BY_DATE, MAKE_PAGE;

    @NotNull
    public final String getQuery() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("usersqlquery");
        return resourceBundle.getString("sqlquery." + this.name().toLowerCase());
    }
}
