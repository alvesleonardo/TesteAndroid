package br.com.leonardoalves.dataInfrastructure.data.entities.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Index

@Entity(tableName = "results",indices = [(Index(value = ["formattedAddress"], unique = true))])
data class StoredResult(
        @PrimaryKey(autoGenerate = true) var id: Long?,
        @ColumnInfo(name = "formattedAddress") var formattedAddress:String,
        @ColumnInfo(name = "latitude")var latitude: String,
        @ColumnInfo(name = "longitude")var longitude: String
)