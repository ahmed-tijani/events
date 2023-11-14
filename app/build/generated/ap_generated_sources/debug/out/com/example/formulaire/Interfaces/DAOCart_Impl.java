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
import com.example.formulaire.Model.Cart;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOCart_Impl implements DAOCart {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cart> __insertionAdapterOfCart;

  private final EntityDeletionOrUpdateAdapter<Cart> __deletionAdapterOfCart;

  private final EntityDeletionOrUpdateAdapter<Cart> __updateAdapterOfCart;

  public DAOCart_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCart = new EntityInsertionAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `cart` (`eid`,`date`,`time`,`ename`,`price`,`quantity`,`category`,`eDate`,`place`,`limit`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        if (entity.getEid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getEid());
        }
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        if (entity.getTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTime());
        }
        if (entity.getEname() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEname());
        }
        if (entity.getPrice() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPrice());
        }
        if (entity.getQuantity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getQuantity());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCategory());
        }
        if (entity.getEDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEDate());
        }
        if (entity.getPlace() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPlace());
        }
        if (entity.getLimit() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLimit());
        }
      }
    };
    this.__deletionAdapterOfCart = new EntityDeletionOrUpdateAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `cart` WHERE `eid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        if (entity.getEid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getEid());
        }
      }
    };
    this.__updateAdapterOfCart = new EntityDeletionOrUpdateAdapter<Cart>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `cart` SET `eid` = ?,`date` = ?,`time` = ?,`ename` = ?,`price` = ?,`quantity` = ?,`category` = ?,`eDate` = ?,`place` = ?,`limit` = ? WHERE `eid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cart entity) {
        if (entity.getEid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getEid());
        }
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        if (entity.getTime() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTime());
        }
        if (entity.getEname() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEname());
        }
        if (entity.getPrice() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getPrice());
        }
        if (entity.getQuantity() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getQuantity());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getCategory());
        }
        if (entity.getEDate() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getEDate());
        }
        if (entity.getPlace() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPlace());
        }
        if (entity.getLimit() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getLimit());
        }
        if (entity.getEid() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getEid());
        }
      }
    };
  }

  @Override
  public void insert(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfCart.insert(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCart.handle(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Cart cart) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCart.handle(cart);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Cart getCartByEid(final String eid) {
    final String _sql = "SELECT * FROM cart WHERE eid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (eid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEid = CursorUtil.getColumnIndexOrThrow(_cursor, "eid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfEname = CursorUtil.getColumnIndexOrThrow(_cursor, "ename");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfEDate = CursorUtil.getColumnIndexOrThrow(_cursor, "eDate");
      final int _cursorIndexOfPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "place");
      final int _cursorIndexOfLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "limit");
      final Cart _result;
      if (_cursor.moveToFirst()) {
        _result = new Cart();
        final String _tmpEid;
        if (_cursor.isNull(_cursorIndexOfEid)) {
          _tmpEid = null;
        } else {
          _tmpEid = _cursor.getString(_cursorIndexOfEid);
        }
        _result.setEid(_tmpEid);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _result.setDate(_tmpDate);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _result.setTime(_tmpTime);
        final String _tmpEname;
        if (_cursor.isNull(_cursorIndexOfEname)) {
          _tmpEname = null;
        } else {
          _tmpEname = _cursor.getString(_cursorIndexOfEname);
        }
        _result.setEname(_tmpEname);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _result.setPrice(_tmpPrice);
        final String _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
        }
        _result.setQuantity(_tmpQuantity);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _result.setCategory(_tmpCategory);
        final String _tmpEDate;
        if (_cursor.isNull(_cursorIndexOfEDate)) {
          _tmpEDate = null;
        } else {
          _tmpEDate = _cursor.getString(_cursorIndexOfEDate);
        }
        _result.setEDate(_tmpEDate);
        final String _tmpPlace;
        if (_cursor.isNull(_cursorIndexOfPlace)) {
          _tmpPlace = null;
        } else {
          _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
        }
        _result.setPlace(_tmpPlace);
        final String _tmpLimit;
        if (_cursor.isNull(_cursorIndexOfLimit)) {
          _tmpLimit = null;
        } else {
          _tmpLimit = _cursor.getString(_cursorIndexOfLimit);
        }
        _result.setLimit(_tmpLimit);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Cart> getAllCarts() {
    final String _sql = "SELECT * FROM cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEid = CursorUtil.getColumnIndexOrThrow(_cursor, "eid");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final int _cursorIndexOfEname = CursorUtil.getColumnIndexOrThrow(_cursor, "ename");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "quantity");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfEDate = CursorUtil.getColumnIndexOrThrow(_cursor, "eDate");
      final int _cursorIndexOfPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "place");
      final int _cursorIndexOfLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "limit");
      final List<Cart> _result = new ArrayList<Cart>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Cart _item;
        _item = new Cart();
        final String _tmpEid;
        if (_cursor.isNull(_cursorIndexOfEid)) {
          _tmpEid = null;
        } else {
          _tmpEid = _cursor.getString(_cursorIndexOfEid);
        }
        _item.setEid(_tmpEid);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _item.setTime(_tmpTime);
        final String _tmpEname;
        if (_cursor.isNull(_cursorIndexOfEname)) {
          _tmpEname = null;
        } else {
          _tmpEname = _cursor.getString(_cursorIndexOfEname);
        }
        _item.setEname(_tmpEname);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        final String _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
        }
        _item.setQuantity(_tmpQuantity);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.setCategory(_tmpCategory);
        final String _tmpEDate;
        if (_cursor.isNull(_cursorIndexOfEDate)) {
          _tmpEDate = null;
        } else {
          _tmpEDate = _cursor.getString(_cursorIndexOfEDate);
        }
        _item.setEDate(_tmpEDate);
        final String _tmpPlace;
        if (_cursor.isNull(_cursorIndexOfPlace)) {
          _tmpPlace = null;
        } else {
          _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
        }
        _item.setPlace(_tmpPlace);
        final String _tmpLimit;
        if (_cursor.isNull(_cursorIndexOfLimit)) {
          _tmpLimit = null;
        } else {
          _tmpLimit = _cursor.getString(_cursorIndexOfLimit);
        }
        _item.setLimit(_tmpLimit);
        _result.add(_item);
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
