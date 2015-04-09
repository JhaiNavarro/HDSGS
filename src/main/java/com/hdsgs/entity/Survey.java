/**
 * This class represents a single survey. Each survey is created by a <a
 * href="User">research leader</a>, has one or more {@link Question questions},
 * and may have zero or more {@link Report reports}. This class was generated,
 * and is used by Hibernate to persist survey data.
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table( name = "survey", catalog = "hdsgs" )
public class Survey implements java.io.Serializable
{
	private static final long serialVersionUID = -655792185168959307L;

	private Integer id;

	private User createdBy;

	private String title;

	private LocalDate startDate;

	private LocalDate endDate;

	private boolean active;

	private List< Report > reports = new ArrayList< Report >( 0 );

	private List< Question > questions = new ArrayList< Question >( 0 );


	protected Survey()
	{

	}


	public Survey( User user, String title, LocalDate startDate, LocalDate endDate, boolean active )
	{
		this.createdBy = user;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.active = active;
	}


	public Survey( User user, String title, LocalDate startDate, LocalDate endDate, boolean active,
			List< Report > reports, List< Question > questions )
	{
		this.createdBy = user;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reports = reports;
		this.questions = questions;
		this.active = active;
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


	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "created_by", nullable = false )
	public User getCreatedBy()
	{
		return this.createdBy;
	}


	public void setCreatedBy( User user )
	{
		this.createdBy = user;
	}


	@Column( name = "title", nullable = false, length = 50 )
	public String getTitle()
	{
		return this.title;
	}


	public void setTitle( String title )
	{
		this.title = title;
	}


	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "start", nullable = false, length = 19 )
	@Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate" )
	public LocalDate getStartDate()
	{
		return this.startDate;
	}


	public void setStartDate( LocalDate startDate )
	{
		this.startDate = startDate;
	}


	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "end", nullable = false, length = 19 )
	@Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate" )
	public LocalDate getEndDate()
	{
		return this.endDate;
	}


	public void setEndDate( LocalDate endDate )
	{
		this.endDate = endDate;
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


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "survey", cascade = CascadeType.ALL )
	public List< Report > getReports()
	{
		return this.reports;
	}


	public void setReports( List< Report > reports )
	{
		this.reports = reports;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true )
	public List< Question > getQuestions()
	{
		return this.questions;
	}


	public void setQuestions( List< Question > questions )
	{
		this.questions = questions;
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

		Survey other = ( Survey ) obj;

		if( createdBy == null )
		{
			if( other.createdBy != null )
			{
				return false;
			}
		}
		else if( createdBy.getId() != other.createdBy.getId() )
		{
			return false;
		}
		if( endDate == null )
		{
			if( other.endDate != null )
			{
				return false;
			}
		}
		else if( !endDate.isEqual( other.endDate ) )
		{
			return false;
		}
		if( questions == null )
		{
			if( other.questions != null )
			{
				return false;
			}
		}
		else if( !questions.equals( other.questions ) )
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
		if( startDate == null )
		{
			if( other.startDate != null )
			{
				return false;
			}
		}
		else if( !startDate.isEqual( other.startDate ) )
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
		if( title == null )
		{
			if( other.title != null )
			{
				return false;
			}
		}
		else if( !title.equals( other.title ) )
		{
			return false;
		}

		return true;
	}


	@Override
	public String toString()
	{
		return "Survey [surveyId=" + id + ", createdById=" + createdBy.getId() + ", title=" + title + ", startDate="
				+ startDate + ", endDate=" + endDate + ", active=" + active + ", reports=" + reports + ", questions="
				+ questions + "]";
	}
}
