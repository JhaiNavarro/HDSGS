/**
 * This is the data transfer object for a survey.
 */

package com.hdsgs.dto;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;

public class SurveyDTO
{
	private int id;

	private String createdBy;

	private String title;

	private LocalDate startDate;

	private LocalDate endDate;

	private boolean active;

	private List< ReportDTO > reports;

	private List< QuestionDTO > questions;


	/**
	 * Initializes a survey DTO with empty values, and empty lists of reports,
	 * and questions.
	 */
	public SurveyDTO()
	{
		this.id = 0;
		this.createdBy = null;
		this.title = null;
		this.startDate = null;
		this.endDate = null;
		this.active = true;
		this.reports = new ArrayList< ReportDTO >( 0 );
		this.questions = new ArrayList< QuestionDTO >( 0 );
	}


	/**
	 * Returns the id of this survey.
	 * 
	 * @return id of this survey
	 */
	public int getId()
	{
		return this.id;
	}


	/**
	 * Sets the id of this survey.
	 * 
	 * @param id
	 *        id of this survey
	 */
	public void setId( int id )
	{
		this.id = id;
	}


	/**
	 * Returns the title of this survey.
	 * 
	 * @return title of this survey
	 */
	public String getTitle()
	{
		return this.title;
	}


	/**
	 * Sets the title of this survey.
	 * 
	 * @param title
	 *        title of this survey
	 */
	public void setTitle( String title )
	{
		this.title = title;
	}


	/**
	 * Returns the username of the creator of this survey.
	 * 
	 * @return the username of the creator of this survey
	 */
	public String getCreatedBy()
	{
		return this.createdBy;
	}


	/**
	 * Sets the username of the creator of this survey.
	 * 
	 * @param createdBy
	 *        username of the creator of this survey
	 */
	public void setCreatedBy( String createdBy )
	{
		this.createdBy = createdBy;
	}


	/**
	 * Returns the date when this survey starts.
	 * 
	 * @return date when this survey starts
	 */
	public LocalDate getStartDate()
	{
		return this.startDate;
	}


	/**
	 * Sets the date when this survey starts.
	 * 
	 * @param startDate
	 *        date when this survey starts
	 */
	public void setStartDate( LocalDate startDate )
	{
		this.startDate = startDate;
	}


	/**
	 * Returns the date when this survey ends.
	 * 
	 * @return date when this survey ends
	 */
	public LocalDate getEndDate()
	{
		return this.endDate;
	}


	/**
	 * Sets the date when this survey ends.
	 * 
	 * @param endDate
	 *        date when this survey ends
	 */
	public void setEndDate( LocalDate endDate )
	{
		this.endDate = endDate;
	}


	/**
	 * Returns whether this survey is active.
	 * 
	 * @return {@code true}, {@code false}
	 */
	public boolean isActive()
	{
		return this.active;
	}


	/**
	 * Sets whether this survey is active.
	 * 
	 * @param active
	 *        defaults to {@code true} during initialization
	 */
	public void setActive( boolean active )
	{
		this.active = active;
	}


	/**
	 * Returns the list of reports for the results of this survey.
	 * 
	 * @return list of reports for the results of this survey
	 */
	public List< ReportDTO > getReports()
	{
		return this.reports;
	}


	/**
	 * Sets the list of reports for the results of this survey.
	 * 
	 * @param reports
	 *        list of reports for the results of this survey
	 */
	public void setReports( List< ReportDTO > reports )
	{
		this.reports.addAll( reports );
	}


	/**
	 * Returns the list of questions for this survey.
	 * 
	 * @return list of questions for this survey
	 */
	public List< QuestionDTO > getQuestions()
	{
		return this.questions;
	}


	/**
	 * Sets the list of questions for this survey.
	 * 
	 * @param questions
	 *        list of questions for this survey
	 */
	public void setQuestions( List< QuestionDTO > questions )
	{
		this.questions = questions;
	}


	/**
	 * Compares the specified object with this survey.
	 * 
	 * @param obj
	 *        the object to compare to
	 * @return {@code true} if all the fields of this survey and the object's
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

		SurveyDTO other = ( SurveyDTO ) obj;

		if( createdBy == null )
		{
			if( other.createdBy != null )
			{
				return false;
			}
		}
		else if( !createdBy.equals( other.createdBy ) )
		{
			return false;
		}

		if( active != other.active )
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
		else if( !endDate.equals( other.endDate ) )
		{
			return false;
		}

		if( id != other.id )
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
		else if( !startDate.equals( other.startDate ) )
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
}
