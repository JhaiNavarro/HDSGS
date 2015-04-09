/**
 * This class represents a single survey question. Each question belongs to a
 * {@link Survey}. This class was generated, and is primarily used by Hibernate
 * to persist survey question data.
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

@Entity
@Table( name = "question", catalog = "hdsgs" )
public class Question implements java.io.Serializable
{
	private static final long serialVersionUID = 668614329316454906L;

	private Integer id;

	private Survey survey;

	private int number;

	private String question;

	private String inputType;

	private List< QuestionChoice > choices = new ArrayList< QuestionChoice >( 0 );

	private List< QuestionFunction > functions = new ArrayList< QuestionFunction >( 0 );


	protected Question()
	{

	}


	public Question( Survey survey, int number, String question, String inputType )
	{
		this.survey = survey;
		this.number = number;
		this.question = question;
		this.inputType = inputType;
	}


	public Question( Survey survey, int number, String question, String inputType, List< QuestionChoice > choices,
			List< QuestionFunction > functions )
	{
		this.survey = survey;
		this.number = number;
		this.question = question;
		this.inputType = inputType;
		this.choices = choices;
		this.functions = functions;
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


	@Column( name = "question_number", nullable = false )
	public int getNumber()
	{
		return this.number;
	}


	public void setNumber( int number )
	{
		this.number = number;
	}


	@Column( name = "question", nullable = false )
	public String getQuestion()
	{
		return this.question;
	}


	public void setQuestion( String question )
	{
		this.question = question;
	}


	@Column( name = "input_type", nullable = false,
			columnDefinition = "enum('number', 'radio', 'checkbox', 'dropdown')" )
	public String getInputType()
	{
		return this.inputType;
	}


	public void setInputType( String inputType )
	{
		this.inputType = inputType;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true )
	public List< QuestionChoice > getChoices()
	{
		return this.choices;
	}


	public void setChoices( List< QuestionChoice > choices )
	{
		this.choices = choices;
	}


	@OneToMany( fetch = FetchType.LAZY, mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true )
	public List< QuestionFunction > getFunctions()
	{
		return this.functions;
	}


	public void setFunctions( List< QuestionFunction > functions )
	{
		this.functions = functions;
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

		Question other = ( Question ) obj;

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
		if( number != other.number )
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

		return true;
	}


	@Override
	public String toString()
	{
		return "Question [id=" + id + ", surveyId=" + survey.getId() + ", number=" + number + ", question=" + question
				+ ", inputType=" + inputType + ", choices=" + choices + ", functions=" + functions + "]";
	}
}
