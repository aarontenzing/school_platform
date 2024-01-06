package com.app.platform.model;

public interface Gebruiker {

	public String getId();

	public void setId(String id);

	public String getNaam();

	public void setNaam(String naam);

	public String getPaswoord();

	public void setPaswoord(String paswoord);

	public String getRol();

	public void setRol(String rol);

	public int getEnabled();

	public void setEnabled(int enabled);
}
