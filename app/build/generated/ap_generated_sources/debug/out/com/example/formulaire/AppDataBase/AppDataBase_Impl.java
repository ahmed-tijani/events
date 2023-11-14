package com.example.formulaire.AppDataBase;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.formulaire.Interfaces.DAOCart;
import com.example.formulaire.Interfaces.DAOCart_Impl;
import com.example.formulaire.Interfaces.DAOEvents;
import com.example.formulaire.Interfaces.DAOEvents_Impl;
import com.example.formulaire.Interfaces.DAOUser;
import com.example.formulaire.Interfaces.DAOUser_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDataBase_Impl extends AppDataBase {
  private volatile DAOUser _dAOUser;

  private volatile DAOEvents _dAOEvents;

  private volatile DAOCart _dAOCart;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(6) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `events` (`pid` TEXT NOT NULL, `category` TEXT, `date` TEXT, `eDate` TEXT, `eTime` TEXT, `image` TEXT, `limit` TEXT, `name` TEXT, `place` TEXT, `price` TEXT, `time` TEXT, PRIMARY KEY(`pid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`phone` TEXT NOT NULL, `name` TEXT, `password` TEXT, `image` TEXT, `address` TEXT, PRIMARY KEY(`phone`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cart` (`eid` TEXT NOT NULL, `date` TEXT, `time` TEXT, `ename` TEXT, `price` TEXT, `quantity` TEXT, `category` TEXT, `eDate` TEXT, `place` TEXT, `limit` TEXT, PRIMARY KEY(`eid`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5719062582e2fdd619eef6f4704f6602')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `events`");
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `cart`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsEvents = new HashMap<String, TableInfo.Column>(11);
        _columnsEvents.put("pid", new TableInfo.Column("pid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("eDate", new TableInfo.Column("eDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("eTime", new TableInfo.Column("eTime", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("limit", new TableInfo.Column("limit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("place", new TableInfo.Column("place", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("price", new TableInfo.Column("price", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEvents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEvents = new TableInfo("events", _columnsEvents, _foreignKeysEvents, _indicesEvents);
        final TableInfo _existingEvents = TableInfo.read(db, "events");
        if (!_infoEvents.equals(_existingEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "events(com.example.formulaire.Model.Events).\n"
                  + " Expected:\n" + _infoEvents + "\n"
                  + " Found:\n" + _existingEvents);
        }
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(5);
        _columnsUsers.put("phone", new TableInfo.Column("phone", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.example.formulaire.Model.Users).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsCart = new HashMap<String, TableInfo.Column>(10);
        _columnsCart.put("eid", new TableInfo.Column("eid", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("ename", new TableInfo.Column("ename", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("price", new TableInfo.Column("price", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("quantity", new TableInfo.Column("quantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("category", new TableInfo.Column("category", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("eDate", new TableInfo.Column("eDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("place", new TableInfo.Column("place", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("limit", new TableInfo.Column("limit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCart = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCart = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCart = new TableInfo("cart", _columnsCart, _foreignKeysCart, _indicesCart);
        final TableInfo _existingCart = TableInfo.read(db, "cart");
        if (!_infoCart.equals(_existingCart)) {
          return new RoomOpenHelper.ValidationResult(false, "cart(com.example.formulaire.Model.Cart).\n"
                  + " Expected:\n" + _infoCart + "\n"
                  + " Found:\n" + _existingCart);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5719062582e2fdd619eef6f4704f6602", "d6a77da7daaaf38de4df9a96973bc4e3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "events","users","cart");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `events`");
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `cart`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DAOUser.class, DAOUser_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOEvents.class, DAOEvents_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAOCart.class, DAOCart_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public DAOUser userDao() {
    if (_dAOUser != null) {
      return _dAOUser;
    } else {
      synchronized(this) {
        if(_dAOUser == null) {
          _dAOUser = new DAOUser_Impl(this);
        }
        return _dAOUser;
      }
    }
  }

  @Override
  public DAOEvents eventDao() {
    if (_dAOEvents != null) {
      return _dAOEvents;
    } else {
      synchronized(this) {
        if(_dAOEvents == null) {
          _dAOEvents = new DAOEvents_Impl(this);
        }
        return _dAOEvents;
      }
    }
  }

  @Override
  public DAOCart cartDao() {
    if (_dAOCart != null) {
      return _dAOCart;
    } else {
      synchronized(this) {
        if(_dAOCart == null) {
          _dAOCart = new DAOCart_Impl(this);
        }
        return _dAOCart;
      }
    }
  }
}
