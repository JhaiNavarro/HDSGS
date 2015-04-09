/**
 * This class represents a single survey report. Each report is created by a
 * {@link User}, and contains statistics for each question of a {@link Survey}.
 * It also holds the URL to which this report can be found. This class was
 * generated, and is primarily used by Hibernate to persist survey report data.
 */

package com.hdsgs.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

@Entity
@Table( name = "report", catalog = "hdsgs" )
public class Report implements java.io.Serializable
{
	private static final long serialVersionUID = 1414636062813857462L;

	private Integer id;

	private Survey survey;

	private User uploader;

	private LocalDate uploadDate;

	private String url;


	protected Report()
	{

	}


	public Report( Survey survey, User uploader, LocalDate uploadDate, String url )
	{
		this.survey = survey;
		this.uploader = uploader;
		this.uploadDate = uploadDate;
		this.url = url;
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
	@JoinColumn( name = "survey_id", nullable = false )
	public Survey getSurvey()
	{
		return this.survey;
	}


	public void setSurvey( Survey survey )
	{
		this.survey = survey;
	}


	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "uploaded_by", nullable = false )
	public User getUploader()
	{
		return this.uploader;
	}


	public void setUploader( User uploader )
	{
		this.uploader = uploader;
	}


	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "uploaded_on", nullable = false, length = 19 )
	@Type( type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate" )
	public LocalDate getUploadDate()
	{
		return this.uploadDate;
	}


	public void setUploadDate( LocalDate uploadDate )
	{
		this.uploadDate = uploadDate;
	}


	@Column( name = "url", nullable = false )
	public String getUrl()
	{
		return this.url;
	}


	public void setUrl( String url )
	{
		this.url = url;
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

		Report other = ( Report ) obj;

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
		if( survey == null )
		{
			if( other.survey != null )
			{
				return false;
			}
		}
		else if( survey.getId() != other.survey.getId() )
		{
			return false;
		}
		if( uploadDate == null )
		{
			if( other.uploadDate != null )
			{
				return false;
			}
		}
		else if( !uploadDate.isEqual( other.uploadDate ) )
		{
			return false;
		}
		if( uploader == null )
		{
			if( other.uploader != null )
			{
				return false;
			}
		}
		else if( uploader.getId() != other.uploader.getId() )
		{
			return false;
		}
		if( url == null )
		{
			if( other.url != null )
			{
				return false;
			}
		}
		else if( !url.equals( other.url ) )
		{
			return false;
		}

		return true;
	}


	@Override
	public String toString()
	{
		return "Report [reportId=" + id + ", surveyId=" + survey.getId() + ", uploaderId=" + uploader.getId()
				+ ", uploadDate=" + uploadDate + ", url=" + url + "]";
	}
}
