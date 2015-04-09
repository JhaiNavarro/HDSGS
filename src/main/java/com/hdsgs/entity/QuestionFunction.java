/**
 * This class represents a single survey question result function. Each function
 * belongs to a {@link Question}. Permissible values are average, minimum,
 * maximum, and tally. This class represents the statistics that will be
 * generated for this question. This class was generated, and is primarily used
 * by Hibernate to persist survey question options data.
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
@Table( name = "question_function", catalog = "hdsgs" )
public class QuestionFunction implements java.io.Serializable
{
	private static final long serialVersionUID = 286450609474918542L;

	private Integer id;

	private Question question;

	private String functionToCompute;


	protected QuestionFunction()
	{

	}


	public QuestionFunction( Question question, String functionToCompute )
	{
		this.question = question;
		this.functionToCompute = functionToCompute;
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


	@Column( name = "function_to_compute", nullable = false,
			columnDefinition = "enum('average', 'minimum', 'maximum', 'tally')" )
	public String getFunctionToCompute()
	{
		return this.functionToCompute;
	}


	public void setFunctionToCompute( String functionToCompute )
	{
		this.functionToCompute = functionToCompute;
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

		QuestionFunction other = ( QuestionFunction ) obj;

		if( functionToCompute == null )
		{
			if( other.functionToCompute != null )
			{
				return false;
			}
		}
		else if( !functionToCompute.equals( other.functionToCompute ) )
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
		return "QuestionFunction [id=" + id + ", questionId=" + question.getId() + ", functionToCompute="
				+ functionToCompute + "]";
	}
}
