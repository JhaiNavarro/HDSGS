/**
 * This class represents a single user. Each user is classified as a
 * contributor, a research leader or a super admin. Only a research leader can
 * create zero or more {@link Survey surveys}, and publish zero or more
 * {@link Report reports}. This class was generated, and is used by Hibernate to
 * persist user data.
 */

package com.hdsgs.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table( name = "user", catalog = "hdsgs", uniqueConstraints = @UniqueConstraint( columnNames = "username" ) )
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = -6914829311780412869L;

	private Integer id;

	private String username;

	private String password;

	private String name;

	private String designation;

	private String institution;

	private String email;

	private String role;

	private boolean active;

	private List< Report > reports = new ArrayList< Report >( 0 );

	private List< Survey > surveys = new ArrayList< Survey >( 0 );


	protected User()
	{

	}


	public User( String username, String password, String name, String designation, String institution, String email,
			String role, boolean active )
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.designation = designation;
		this.institution = institution;
		this.email = email;
		this.role = role;
		this.active = active;
	}


	public User( String username, String password, String name, String designation, String institution, String email,
			String role, boolean active, List< Report > reports, List< Survey > surveys )
	{
		this.username = username;
		this.password = password;
		this.name = name;
		this.designation = designation;
		this.institution = institution;
		this.email = email;
		this.role = role;
		this.active = active;
		this.reports = reports;
		this.surveys = surveys;
	}


	@Id
	@GeneratedValue( strategy = IDENTITY )
	@Column( name = "id", unique = true, nullable = false )
	public Integer getId()
	{
		return this.id;
	}


	public void setId( Integer id )
	{
		this.id = id;
	}


	@Column( name = "username", unique = true, nullable = false, length = 20 )
	public String getUsername()
	{
		return this.username;
	}


	public void setUsername( String username )
	{
		this.username = username;
	}


	@Column( name = "password", nullable = false, length = 20 )
	public String getPassword()
	{
		return this.password;
	}


	public void setPassword( String password )
	{
		this.password = password;
	}


	@Column( name = "name", nullable = false, length = 50 )
	public String getName()
	{
		return this.name;
	}


	public void setName( String name )
	{
		this.name = name;
	}


	@Column( name = "designation", nullable = false, length = 50 )
	public String getDesignation()
	{
		return this.designation;
	}


	public void setDesignation( String designation )
	{
		this.designation = designation;
	}


	@Column( name = "institution", nullable = false, length = 50 )
	public String getInstitution()
	{
		return this.institution;
	}


	public void setInstitution( String institution )
	{
		this.institution = institution;
	}


	@Column( name = "email", nullable = false, length = 50 )
	public String getEmail()
	{
		return this.email;
	}


	public void setEmail( String email )
	{
		this.email = email;
	}


	@Column( name = "role", nullable = false, columnDefinition = "enum('contributor', 'researchLeader', 'superAdmin'" )
	public String getRole()
	{
		return this.role;
	}


	public void setRole( String role )
	{
		this.role = role;
	}


	@Column( name = "active", nullable = false )
	public boolean isActive()
	{
		return this.active;
	}


	public void setActive( boolean active )
	{
		this.active = active;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "uploader", cascade = CascadeType.ALL )
	public List< Report > getReports()
	{
		return this.reports;
	}


	public void setReports( List< Report > reports )
	{
		this.reports = reports;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "createdBy", cascade = CascadeType.ALL )
	public List< Survey > getSurveys()
	{
		return this.surveys;
	}


	public void setSurveys( List< Survey > surveys )
	{
		this.surveys = surveys;
	}


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

		User other = ( User ) obj;

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
		if( id == null )
		{
			if( other.id != null )
			{
				return false;
			}
		}
		else if( !id.equals( other.id ) )
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
		if( active != other.active )
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


	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", designation=" + designation + ", institution=" + institution + ", email=" + email + ", role="
				+ role + ", isActive=" + active + ", reports=" + reports + ", surveys=" + surveys + "]";
	}

}
