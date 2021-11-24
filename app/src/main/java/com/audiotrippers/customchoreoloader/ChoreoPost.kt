package com.audiotrippers.customchoreoloader

import android.os.Build
import androidx.annotation.RequiresApi
import java.net.URL
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset

/** The duration of a choreo song in minutes and seconds. */
data class SongDuration(val minutes: Int, val seconds: Int)

/** A new custom choreography posting from the ATCD server. */
data class ChoreoPost @RequiresApi(Build.VERSION_CODES.O) constructor(
  val songTitle: String = "unknown",
  val songArtist: String = "unknown",
  val choreographer: String = "unknown",
  val difficulties: Array<String> = arrayOf("Other"),
  val bpm: Double = Double.NaN,
  val length: SongDuration = SongDuration(0, 0),
  val fileUrls: Array<URL> = emptyArray(),
  val videoUrls: Array<URL> = emptyArray(),
  val releaseDate: LocalDateTime = Instant.EPOCH.atOffset(ZoneOffset.UTC).toLocalDateTime(),
  val downloads: Int = 0,
) {
  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (other !is ChoreoPost) return false

    if (songTitle != other.songTitle) return false
    if (songArtist != other.songArtist) return false
    if (choreographer != other.choreographer) return false
    if (!difficulties.contentEquals(other.difficulties)) return false
    if (bpm != other.bpm) return false
    if (length != other.length) return false
    if (!fileUrls.contentEquals(other.fileUrls)) return false
    if (!videoUrls.contentEquals(other.videoUrls)) return false
    if (releaseDate != other.releaseDate) return false

    return true
  }

  override fun hashCode(): Int {
    var result = songTitle.hashCode()
    result = 31 * result + songArtist.hashCode()
    result = 31 * result + choreographer.hashCode()
    result = 31 * result + difficulties.contentHashCode()
    result = 31 * result + bpm.hashCode()
    result = 31 * result + length.hashCode()
    result = 31 * result + fileUrls.contentHashCode()
    result = 31 * result + videoUrls.contentHashCode()
    result = 31 * result + releaseDate.hashCode()
    return result
  }
}