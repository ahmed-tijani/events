package com.example.formulaire.Interfaces;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.formulaire.Model.Events;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAOEvents_Impl implements DAOEvents {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Events> __insertionAdapterOfEvents;

  private final EntityDeletionOrUpdateAdapter<Events> __deletionAdapterOfEvents;

  private final EntityDeletionOrUpdateAdapter<Events> __updateAdapterOfEvents;

  public DAOEvents_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvents = new EntityInsertionAdapter<Events>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `events` (`pid`,`category`,`date`,`eDate`,`eTime`,`image`,`limit`,`name`,`place`,`price`,`time`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Events entity) {
        if (entity.getPid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPid());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCategory());
        }
        if (entity.getDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDate());
        }
        if (entity.getEDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEDate());
        }
        if (entity.getETime() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getETime());
        }
        if (entity.getImage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getImage());
        }
        if (entity.getLimit() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getLimit());
        }
        if (entity.getName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getName());
        }
        if (entity.getPlace() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPlace());
        }
        if (entity.getPrice() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPrice());
        }
        if (entity.getTime() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getTime());
        }
      }
    };
    this.__deletionAdapterOfEvents = new EntityDeletionOrUpdateAdapter<Events>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `events` WHERE `pid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Events entity) {
        if (entity.getPid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPid());
        }
      }
    };
    this.__updateAdapterOfEvents = new EntityDeletionOrUpdateAdapter<Events>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `events` SET `pid` = ?,`category` = ?,`date` = ?,`eDate` = ?,`eTime` = ?,`image` = ?,`limit` = ?,`name` = ?,`place` = ?,`price` = ?,`time` = ? WHERE `pid` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Events entity) {
        if (entity.getPid() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getPid());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getCategory());
        }
        if (entity.getDate() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDate());
        }
        if (entity.getEDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getEDate());
        }
        if (entity.getETime() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getETime());
        }
        if (entity.getImage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getImage());
        }
        if (entity.getLimit() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getLimit());
        }
        if (entity.getName() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getName());
        }
        if (entity.getPlace() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getPlace());
        }
        if (entity.getPrice() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getPrice());
        }
        if (entity.getTime() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getTime());
        }
        if (entity.getPid() == null) {
          statement.bindNull(12);
        } else {
          statement.bindString(12, entity.getPid());
        }
      }
    };
  }

  @Override
  public void insert(final Events events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEvents.insert(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Events events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEvents.handle(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Events events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEvents.handle(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Events getEventsByPid(final String pid) {
    final String _sql = "SELECT * FROM events WHERE pid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pid == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pid);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfEDate = CursorUtil.getColumnIndexOrThrow(_cursor, "eDate");
      final int _cursorIndexOfETime = CursorUtil.getColumnIndexOrThrow(_cursor, "eTime");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "limit");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "place");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final Events _result;
      if (_cursor.moveToFirst()) {
        _result = new Events();
        final String _tmpPid;
        if (_cursor.isNull(_cursorIndexOfPid)) {
          _tmpPid = null;
        } else {
          _tmpPid = _cursor.getString(_cursorIndexOfPid);
        }
        _result.setPid(_tmpPid);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _result.setCategory(_tmpCategory);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _result.setDate(_tmpDate);
        final String _tmpEDate;
        if (_cursor.isNull(_cursorIndexOfEDate)) {
          _tmpEDate = null;
        } else {
          _tmpEDate = _cursor.getString(_cursorIndexOfEDate);
        }
        _result.setEDate(_tmpEDate);
        final String _tmpETime;
        if (_cursor.isNull(_cursorIndexOfETime)) {
          _tmpETime = null;
        } else {
          _tmpETime = _cursor.getString(_cursorIndexOfETime);
        }
        _result.setETime(_tmpETime);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _result.setImage(_tmpImage);
        final String _tmpLimit;
        if (_cursor.isNull(_cursorIndexOfLimit)) {
          _tmpLimit = null;
        } else {
          _tmpLimit = _cursor.getString(_cursorIndexOfLimit);
        }
        _result.setLimit(_tmpLimit);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
        final String _tmpPlace;
        if (_cursor.isNull(_cursorIndexOfPlace)) {
          _tmpPlace = null;
        } else {
          _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
        }
        _result.setPlace(_tmpPlace);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _result.setPrice(_tmpPrice);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _result.setTime(_tmpTime);
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
  public List<Events> getAllEvents() {
    final String _sql = "SELECT * FROM events";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
      final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfEDate = CursorUtil.getColumnIndexOrThrow(_cursor, "eDate");
      final int _cursorIndexOfETime = CursorUtil.getColumnIndexOrThrow(_cursor, "eTime");
      final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
      final int _cursorIndexOfLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "limit");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "place");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
      final List<Events> _result = new ArrayList<Events>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Events _item;
        _item = new Events();
        final String _tmpPid;
        if (_cursor.isNull(_cursorIndexOfPid)) {
          _tmpPid = null;
        } else {
          _tmpPid = _cursor.getString(_cursorIndexOfPid);
        }
        _item.setPid(_tmpPid);
        final String _tmpCategory;
        if (_cursor.isNull(_cursorIndexOfCategory)) {
          _tmpCategory = null;
        } else {
          _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        }
        _item.setCategory(_tmpCategory);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final String _tmpEDate;
        if (_cursor.isNull(_cursorIndexOfEDate)) {
          _tmpEDate = null;
        } else {
          _tmpEDate = _cursor.getString(_cursorIndexOfEDate);
        }
        _item.setEDate(_tmpEDate);
        final String _tmpETime;
        if (_cursor.isNull(_cursorIndexOfETime)) {
          _tmpETime = null;
        } else {
          _tmpETime = _cursor.getString(_cursorIndexOfETime);
        }
        _item.setETime(_tmpETime);
        final String _tmpImage;
        if (_cursor.isNull(_cursorIndexOfImage)) {
          _tmpImage = null;
        } else {
          _tmpImage = _cursor.getString(_cursorIndexOfImage);
        }
        _item.setImage(_tmpImage);
        final String _tmpLimit;
        if (_cursor.isNull(_cursorIndexOfLimit)) {
          _tmpLimit = null;
        } else {
          _tmpLimit = _cursor.getString(_cursorIndexOfLimit);
        }
        _item.setLimit(_tmpLimit);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpPlace;
        if (_cursor.isNull(_cursorIndexOfPlace)) {
          _tmpPlace = null;
        } else {
          _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
        }
        _item.setPlace(_tmpPlace);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        final String _tmpTime;
        if (_cursor.isNull(_cursorIndexOfTime)) {
          _tmpTime = null;
        } else {
          _tmpTime = _cursor.getString(_cursorIndexOfTime);
        }
        _item.setTime(_tmpTime);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Events> getEventById(final String eventId) {
    final String _sql = "SELECT * FROM events WHERE pid = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (eventId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, eventId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"events"}, false, new Callable<Events>() {
      @Override
      @Nullable
      public Events call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPid = CursorUtil.getColumnIndexOrThrow(_cursor, "pid");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfEDate = CursorUtil.getColumnIndexOrThrow(_cursor, "eDate");
          final int _cursorIndexOfETime = CursorUtil.getColumnIndexOrThrow(_cursor, "eTime");
          final int _cursorIndexOfImage = CursorUtil.getColumnIndexOrThrow(_cursor, "image");
          final int _cursorIndexOfLimit = CursorUtil.getColumnIndexOrThrow(_cursor, "limit");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfPlace = CursorUtil.getColumnIndexOrThrow(_cursor, "place");
          final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
          final int _cursorIndexOfTime = CursorUtil.getColumnIndexOrThrow(_cursor, "time");
          final Events _result;
          if (_cursor.moveToFirst()) {
            _result = new Events();
            final String _tmpPid;
            if (_cursor.isNull(_cursorIndexOfPid)) {
              _tmpPid = null;
            } else {
              _tmpPid = _cursor.getString(_cursorIndexOfPid);
            }
            _result.setPid(_tmpPid);
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            _result.setCategory(_tmpCategory);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            _result.setDate(_tmpDate);
            final String _tmpEDate;
            if (_cursor.isNull(_cursorIndexOfEDate)) {
              _tmpEDate = null;
            } else {
              _tmpEDate = _cursor.getString(_cursorIndexOfEDate);
            }
            _result.setEDate(_tmpEDate);
            final String _tmpETime;
            if (_cursor.isNull(_cursorIndexOfETime)) {
              _tmpETime = null;
            } else {
              _tmpETime = _cursor.getString(_cursorIndexOfETime);
            }
            _result.setETime(_tmpETime);
            final String _tmpImage;
            if (_cursor.isNull(_cursorIndexOfImage)) {
              _tmpImage = null;
            } else {
              _tmpImage = _cursor.getString(_cursorIndexOfImage);
            }
            _result.setImage(_tmpImage);
            final String _tmpLimit;
            if (_cursor.isNull(_cursorIndexOfLimit)) {
              _tmpLimit = null;
            } else {
              _tmpLimit = _cursor.getString(_cursorIndexOfLimit);
            }
            _result.setLimit(_tmpLimit);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            _result.setName(_tmpName);
            final String _tmpPlace;
            if (_cursor.isNull(_cursorIndexOfPlace)) {
              _tmpPlace = null;
            } else {
              _tmpPlace = _cursor.getString(_cursorIndexOfPlace);
            }
            _result.setPlace(_tmpPlace);
            final String _tmpPrice;
            if (_cursor.isNull(_cursorIndexOfPrice)) {
              _tmpPrice = null;
            } else {
              _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
            }
            _result.setPrice(_tmpPrice);
            final String _tmpTime;
            if (_cursor.isNull(_cursorIndexOfTime)) {
              _tmpTime = null;
            } else {
              _tmpTime = _cursor.getString(_cursorIndexOfTime);
            }
            _result.setTime(_tmpTime);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
