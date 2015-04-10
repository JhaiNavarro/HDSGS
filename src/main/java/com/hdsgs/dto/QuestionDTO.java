/**
 * This is the data transfer object for a survey question.
 */

package com.hdsgs.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO
{
	private int surveyId;

	private int questionNumber;

	private String question;

	private String inputType;

	private List< String > functions;

	private List< String > choices;


	public QuestionDTO()
	{
		this.surveyId = 0;
		this.questionNumber = 0;
		this.question = "";
		this.inputType = "";
		this.functions = new ArrayList< String >( 0 );
		this.choices = new ArrayList< String >( 0 );
	}


	/**
	 * Returns the question number of this question.
	 * 
	 * @return question number of this question
	 */

	public int getQuestionNumber()
	{
		return this.questionNumber;
	}


	/**
	 * Sets the question number of this question.
	 * 
	 * @param questionNumber
	 *        question number of this question
	 */

	public void setQuestionNumber( int questionNumber )
	{
		this.questionNumber = questionNumber;
	}


	/**
	 * Returns the id of the survey to which this question is found.
	 * 
	 * @return id of the survey to which this question is found
	 */

	public int getSurveyId()
	{
		return this.surveyId;
	}


	/**
	 * Sets the survey to which this question is found.
	 * 
	 * @param surveyId
	 *        the survey to which this question is found
	 */

	public void setSurveyId( int surveyId )
	{
		this.surveyId = surveyId;
	}


	/**
	 * Returns the question string.
	 * 
	 * @return question string
	 */

	public String getQuestion()
	{
		return this.question;
	}


	/**
	 * Sets the question string.
	 * 
	 * @param question
	 *        string
	 */

	public void setQuestion( String question )
	{
		this.question = question;
	}


	/**
	 * Returns the input type of this question.
	 * 
	 * @return inputType of this question
	 */

	public String getInputType()
	{
		return this.inputType;
	}


	/**
	 * Sets the input type of the question.
	 * 
	 * @param inputType
	 *        input type of this question
	 */

	public void setInputType( String inputType )
	{
		this.inputType = inputType;
	}


	/**
	 * Returns the list of choices for this question.
	 * 
	 * @return list of choices for this question
	 */
	public List< String > getChoices()
	{
		return this.choices;
	}


	/**
	 * Sets the list of choices for this question.
	 * 
	 * @param questionChoices
	 *        list of choices for this question.
	 */
	public void setChoices( List< String > questionChoices )
	{
		this.choices = questionChoices;
	}


	/**
	 * Returns the list of result functions to compute for this question.
	 * 
	 * @return list of result functions to compute for this question
	 */
	public List< String > getFunctions()
	{
		return functions;
	}


	/**
	 * Sets the list of result functions to compute for this question.
	 * 
	 * @param functions
	 *        list of result functions to compute for this question.
	 */
	public void setFunctions( List< String > functions )
	{
		this.functions = functions;
	}


	/**
	 * Compares the specified object with this survey question.
	 * 
	 * @param obj
	 *        the object to compare to
	 * @return {@code true} if all the fields of this survey question and the
	 *         object's are the same, {@code false} otherwise
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

		QuestionDTO other = ( QuestionDTO ) obj;

		if( inputType == null )
		{
			if( other.inputType != null )
			{
				return false;
			}
		}
		else if( !inputType.equals( other.inputType ) )
		{
			return false;
		}

		if( question == null )
		{
			if( other.question != null )
			{
				return false;
			}
		}
		else if( !question.equals( other.question ) )
		{
			return false;
		}

		if( choices == null )
		{
			if( other.choices != null )
			{
				return false;
			}
		}
		else if( !choices.equals( other.choices ) )
		{
			return false;
		}

		if( functions == null )
		{
			if( other.functions != null )
			{
				return false;
			}
		}
		else if( !functions.equals( other.functions ) )
		{
			return false;
		}

		if( questionNumber != other.questionNumber )
		{
			return false;
		}

		if( surveyId != other.surveyId )
		{
			return false;
		}

		return true;
	}
}
