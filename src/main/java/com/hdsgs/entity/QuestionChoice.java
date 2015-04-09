/**
 * This class represents a single survey question option. Each option belongs to
 * a {@link Question}. This class was generated, and is primarily used by
 * Hibernate to persist survey question options data.
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

@Entity
@Table( name = "question_choice", catalog = "hdsgs" )
public class QuestionChoice implements java.io.Serializable
{
	private static final long serialVersionUID = 4611404058494930552L;

	private Integer id;

	private Question question;

	private String optionValue;


	protected QuestionChoice()
	{

	}


	public QuestionChoice( Question question, String optionValue )
	{
		this.question = question;
		this.optionValue = optionValue;
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
	@JoinColumn( name = "question_id", nullable = false )
	public Question getQuestion()
	{
		return this.question;
	}


	public void setQuestion( Question question )
	{
		this.question = question;
	}


	@Column( name = "option_value", nullable = false, length = 50 )
	public String getOptionValue()
	{
		return this.optionValue;
	}


	public void setOptionValue( String optionValue )
	{
		this.optionValue = optionValue;
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

		QuestionChoice other = ( QuestionChoice ) obj;

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
		if( optionValue == null )
		{
			if( other.optionValue != null )
			{
				return false;
			}
		}
		else if( !optionValue.equals( other.optionValue ) )
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
		else if( question.getId() != other.question.getId() )
		{
			return false;
		}

		return true;
	}


	@Override
	public String toString()
	{
		return "QuestionChoice [id=" + id + ", questionId=" + question.getId() + ", optionValue=" + optionValue + "]";
	}
}
