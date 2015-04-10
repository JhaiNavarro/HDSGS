/**
 * This is the data transfer object for a user.
 */

package com.hdsgs.dto;

import java.util.ArrayList;
import java.util.List;

public class UserDTO
{
	private String username;

	private String password;

	private String name;

	private String designation;

	private String institution;

	private String email;

	private String role;

	private boolean isActive;

	private List< ReportDTO > reports;

	private List< SurveyDTO > surveys;


	/**
	 * Initializes a user DTO with empty values, and empty lists of reports, and
	 * surveys.
	 */
	public UserDTO()
	{
		this.username = null;
		this.password = null;
		this.name = null;
		this.designation = null;
		this.institution = null;
		this.email = null;
		this.role = null;
		this.isActive = true;
		this.reports = new ArrayList< ReportDTO >( 0 );
		this.surveys = new ArrayList< SurveyDTO >( 0 );
	}


	/**
	 * Returns the username of this user.
	 * 
	 * @return username of this user
	 */
	public String getUsername()
	{
		return this.username;
	}


	/**
	 * Sets the username of this user.
	 * 
	 * @param username
	 *        username of this user
	 */
	public void setUsername( String username )
	{
		this.username = username;
	}


	/**
	 * Returns the password of this user.
	 * 
	 * @return password of this user
	 */
	public String getPassword()
	{
		return this.password;
	}


	/**
	 * Sets the password of this user.
	 * 
	 * @param password
	 *        password of this user
	 */
	public void setPassword( String password )
	{
		this.password = password;
	}


	/**
	 * Returns the name of this user.
	 * 
	 * @return name of this user
	 */
	public String getName()
	{
		return this.name;
	}


	/**
	 * Sets the name of this user.
	 * 
	 * @param name
	 *        name of this user
	 */
	public void setName( String name )
	{
		this.name = name;
	}


	/**
	 * Returns the designation of this user.
	 * 
	 * @return position held by this user
	 */
	public String getDesignation()
	{
		return this.designation;
	}


	/**
	 * Sets the designation of this user.
	 * 
	 * @param designation
	 *        position held by this user
	 */
	public void setDesignation( String designation )
	{
		this.designation = designation;
	}


	/**
	 * Returns the name of the institution where this user belongs to.
	 * 
	 * @return name of the institution where this user belongs to
	 */
	public String getInstitution()
	{
		return this.institution;
	}


	/**
	 * Sets the name of the institution where this user belongs to.
	 * 
	 * @param institution
	 *        name of the institution where this user belongs to
	 */
	public void setInstitution( String institution )
	{
		this.institution = institution;
	}


	/**
	 * Returns the email address of this user.
	 * 
	 * @return email address of this user
	 */
	public String getEmail()
	{
		return this.email;
	}


	/**
	 * Sets the email address of this user.
	 * 
	 * @param email
	 *        email address of this user
	 */
	public void setEmail( String email )
	{
		this.email = email;
	}


	/**
	 * Returns the role of this user.
	 * 
	 * @return role of this user
	 */
	public String getRole()
	{
		return this.role;
	}


	/**
	 * Sets the role of this user.
	 * 
	 * @param role
	 *        role of this user
	 */
	public void setRole( String role )
	{
		this.role = role;
	}


	/**
	 * Returns whether this user is active.
	 * 
	 * @return {@code true}, {@code false}
	 */
	public boolean isActive()
	{
		return this.isActive;
	}


	/**
	 * Sets whether this user is active.
	 * 
	 * @param isActive
	 *        defaults to {@code true} during initialization
	 */
	public void setActive( boolean isActive )
	{
		this.isActive = isActive;
	}


	/**
	 * Returns the list of reports created by this user.
	 * 
	 * @return list of reports created by this user
	 */
	public List< ReportDTO > getReports()
	{
		return this.reports;
	}


	/**
	 * Sets the list of reports created by this user.
	 * 
	 * @param reports
	 *        list of reports created by this user
	 */
	public void setReports( List< ReportDTO > reports )
	{
		this.reports = reports;
	}


	/**
	 * Returns the list of surveys created by this user.
	 * 
	 * @return list of surveys created by this user
	 */
	public List< SurveyDTO > getSurveys()
	{
		return this.surveys;
	}


	/**
	 * Sets the list of surveys created by this user.
	 * 
	 * @param surveys
	 *        list of surveys created by this user
	 */
	public void setSurveys( List< SurveyDTO > surveys )
	{
		this.surveys = surveys;
	}


	/**
	 * Compares the specified object with this user.
	 * 
	 * @param obj
	 *        the object to compare to
	 * @return {@code true} if all the fields of this user and the object's are
	 *         the same, {@code false} otherwise
	 */
	@Override
	public boolean equals( Object obj )
	{
		if( this == obj )
		{
			return true;
		}

		if( obj == null )
		{
			return false;
		}

		if( getClass() != obj.getClass() )
		{
			return false;
		}

		UserDTO other = ( UserDTO ) obj;

		if( designation == null )
		{
			if( other.designation != null )
			{
				return false;
			}
		}
		else if( !designation.equals( other.designation ) )
		{
			return false;
		}

		if( email == null )
		{
			if( other.email != null )
			{
				return false;
			}
		}
		else if( !email.equals( other.email ) )
		{
			return false;
		}

		if( institution == null )
		{
			if( other.institution != null )
			{
				return false;
			}
		}
		else if( !institution.equals( other.institution ) )
		{
			return false;
		}

		if( isActive != other.isActive )
		{
			return false;
		}

		if( name == null )
		{
			if( other.name != null )
			{
				return false;
			}
		}
		else if( !name.equals( other.name ) )
		{
			return false;
		}

		if( password == null )
		{
			if( other.password != null )
			{
				return false;
			}
		}
		else if( !password.equals( other.password ) )
		{
			return false;
		}

		if( reports == null )
		{
			if( other.reports != null )
			{
				return false;
			}
		}
		else if( !reports.equals( other.reports ) )
		{
			return false;
		}

		if( role == null )
		{
			if( other.role != null )
			{
				return false;
			}
		}
		else if( !role.equals( other.role ) )
		{
			return false;
		}

		if( surveys == null )
		{
			if( other.surveys != null )
			{
				return false;
			}
		}
		else if( !surveys.equals( other.surveys ) )
		{
			return false;
		}

		if( username == null )
		{
			if( other.username != null )
			{
				return false;
			}
		}
		else if( !username.equals( other.username ) )
		{
			return false;
		}

		return true;
	}
}
