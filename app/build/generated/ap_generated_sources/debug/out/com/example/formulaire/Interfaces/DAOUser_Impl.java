package com.example.formulaire.Interfaces;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.formulaire.Model.Users;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOUser_Impl implements DAOUser {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Users> __insertionAdapterOfUsers;

  private final EntityDeletionOrUpdateAdapter<Users> __deletionAdapterOfUsers;

  private final EntityDeletionOrUpdateAdapter<Users> __updateAdapterOfUsers;

  public DAOUser_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUsers = new EntityInsertionAdapter<Users>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `users` (`phone`,`name`,`password`,`image`,`address`) VALUES (?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Users entity) {
        if (entity.getPhone() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPhone());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPassword());
        }
        if (entity.getImage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImage());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAddress());
        }
      }
    };
    this.__deletionAdapterOfUsers = new EntityDeletionOrUpdateAdapter<Users>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `users` WHERE `phone` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Users entity) {
        if (entity.getPhone() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPhone());
        }
      }
    };
    this.__updateAdapterOfUsers = new EntityDeletionOrUpdateAdapter<Users>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `phone` = ?,`name` = ?,`password` = ?,`image` = ?,`address` = ? WHERE `phone` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Users entity) {
        if (entity.getPhone() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPhone());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getPassword() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPassword());
        }
        if (entity.getImage() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImage());
        }
        if (entity.getAddress() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAddress());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getPhone());
        }
      }
    };
  }

  @Override
  public void insert(final Users user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUsers.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Users user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUsers.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Users user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUsers.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Users getUserByPhone(final String phone) {
    final String _sql = "SELECT * FROM users WHERE phone = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (phone == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, phone);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "password");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfAddress = CursorUtil.getColumnIndexOrThrow(_cursor, "address");
      final Users _result;
      if (_cursor.moveToFirst()) {
        _result = new Users();
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _result.setPhone(_tmpPhone);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpPassword;
        if (_cursor.isNull(_cursorIndexOfPassword)) {
          _tmpPassword = null;
        } else {
          _tmpPassword = _cursor.getString(_cursorIndexOfPassword);
        }
        _result.setPassword(_tmpPassword);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _result.setImage(_tmpImage);
        final String _tmpAddress;
        if (_cursor.isNull(_cursorIndexOfAddress)) {
          _tmpAddress = null;
        } else {
          _tmpAddress = _cursor.getString(_cursorIndexOfAddress);
        }
        _result.setAddress(_tmpAddress);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
