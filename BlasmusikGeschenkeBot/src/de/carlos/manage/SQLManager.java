package de.carlos.manage;

public class SQLManager {
	public static void onCreate() {
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS reactroles(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, channelid INTEGER, messageid INTEGER, emote VARCHAR, rollenid INTEGER)");
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS timeranks(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, userid INTEGER, guildid INTEGER, time TIMESTAMP DEFAULT CURRENT_TIMESTAMP)");
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS statchannels(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, categoryid INTEGER)");
		
		LiteSQL.onUpdate("CREATE TABLE IF NOT EXISTS musicchannel(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, guildid INTEGER, channelid INTEGER)");
 
	}
}
 