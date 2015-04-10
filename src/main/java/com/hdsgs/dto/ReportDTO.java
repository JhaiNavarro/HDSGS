/**
 * This is the data transfer object for a survey report.
 */

package com.hdsgs.dto;

import org.joda.time.LocalDate;

public class ReportDTO
{
	private int id;

	private int surveyId;

	private String uploader;

	private LocalDate uploadDate;

	private String url;


	/**
	 * Initializes a report DTO with empty values.
	 */
	public ReportDTO()
	{
		this.id = 0;
		this.surveyId = 0;
		this.uploader = null;
		this.uploadDate = null;
		this.url = null;
	}


	/**
	 * Returns the id of this report.
	 * 
	 * @return id of this report
	 */
	public int getId()
	{
		return id;
	}


	/**
	 * Sets the id of this report.
	 * 
	 * @param id
	 *        id of this report
	 */
	public void setId( int id )
	{
		this.id = id;
	}


	/**
	 * Returns the id of the survey where this report generated its data from.
	 * 
	 * @return id of the survey where this report generated its data from
	 */
	public int getSurveyId()
	{
		return this.surveyId;
	}


	/**
	 * Sets the id of the survey where this report generated its data from
	 * 
	 * @param surveyId
	 *        id of the the survey where this report generated its data from
	 */
	public void setSurveyId( int surveyId )
	{
		this.surveyId = surveyId;
	}


	/**
	 * Returns the username of the uploader of this report.
	 * 
	 * @return username of the uploader of this report
	 */
	public String getUploader()
	{
		return this.uploader;
	}


	/**
	 * Sets the username of the uploader of this report.
	 * 
	 * @param uploader
	 *        username of the uploader of this report.
	 */
	public void setUploader( String uploader )
	{
		this.uploader = uploader;
	}


	/**
	 * Returns the date when this report was uploaded.
	 * 
	 * @return the date when this report was uploaded
	 */
	public LocalDate getUploadDate()
	{
		return this.uploadDate;
	}


	/**
	 * Sets the date when this report was uploaded.
	 * 
	 * @param uploadDate
	 *        date when this report was uploaded
	 */
	public void setUploadDate( LocalDate uploadDate )
	{
		this.uploadDate = uploadDate;
	}


	/**
	 * Returns the URL where the report can be found.
	 * 
	 * @return URL where the report can be found
	 */
	public String getUrl()
	{
		return this.url;
	}


	/**
	 * Sets the URL where the report can be found.
	 * 
	 * @param url
	 *        URL where the report can be found
	 */
	public void setUrl( String url )
	{
		this.url = url;
	}


	/**
	 * Compares the specified object with this report.
	 * 
	 * @param obj
	 *        the object to compare to
	 * @return {@code true} if all the fields of this report and the object's
	 *         are the same, {@code false} otherwise
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

		ReportDTO other = ( ReportDTO ) obj;

		if( id != other.id )
		{
			return false;
		}

		if( surveyId != other.surveyId )
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
		else if( !uploadDate.equals( other.uploadDate ) )
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
		else if( !uploader.equals( other.uploader ) )
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
}
