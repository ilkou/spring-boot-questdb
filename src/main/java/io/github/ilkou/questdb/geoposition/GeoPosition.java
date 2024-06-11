package io.github.ilkou.questdb.geoposition;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Table("geo_positions")
public class GeoPosition implements Persistable<String> {

	@Id
	private String id;
	private Timestamp ts;
	private String source;
	private double lat;
	private double lng;
	private String metadata;

	public GeoPosition(Timestamp ts, String source, double lat, double lng, String metadata) {
		this.id = UUID.randomUUID().toString();
		this.ts = ts;
		this.source = source;
		this.lat = lat;
		this.lng = lng;
		this.metadata = metadata;
	}

	@Override
	public boolean isNew() {
		return true;
	}

	// Getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "GeoPosition{" +
				"id='" + id + '\'' +
				", ts='" + ts + '\'' +
				", source='" + source + '\'' +
				", lat=" + lat +
				", lng=" + lng +
				", metadata='" + metadata + '\'' +
				'}';
	}
}


