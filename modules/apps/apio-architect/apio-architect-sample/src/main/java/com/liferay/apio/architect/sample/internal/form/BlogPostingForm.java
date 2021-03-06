/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.apio.architect.sample.internal.form;

import com.liferay.apio.architect.form.Form;
import com.liferay.apio.architect.form.Form.Builder;
import com.liferay.apio.architect.sample.internal.identifier.PersonIdentifier;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the values extracted from a blog posting form.
 *
 * @author Alejandro Hernández
 */
public class BlogPostingForm {

	/**
	 * Builds and returns a {@link Form} that generates a {@code
	 * BlogPostingForm} that depends on the HTTP body.
	 *
	 * @param  formBuilder the {@code Form} builder
	 * @return the {@code BlogPostingForm}
	 */
	public static Form<BlogPostingForm> buildForm(
		Builder<BlogPostingForm> formBuilder) {

		return formBuilder.title(
			__ -> "The blog posting form"
		).description(
			__ -> "This form can be used to create or update a blog posting"
		).constructor(
			BlogPostingForm::new
		).addOptionalNestedModel(
			"comment", BlogPostingCommentCreatorForm::buildForm,
			BlogPostingForm::_setBlogPostingCommentCreatorForm
		).addOptionalNestedModelList(
			"comments", BlogPostingCommentCreatorForm::buildForm,
			BlogPostingForm::_setBlogPostingCommentCreatorForms
		).addRequiredLinkedModel(
			"creator", PersonIdentifier.class, BlogPostingForm::_setCreator
		).addRequiredString(
			"articleBody", BlogPostingForm::_setArticleBody
		).addRequiredString(
			"alternativeHeadline", BlogPostingForm::_setAlternativeHeadline
		).addRequiredString(
			"headline", BlogPostingForm::_setHeadline
		).build();
	}

	/**
	 * Returns the blog posting's alternative headline.
	 *
	 * @return the blog posting's alternative headline
	 */
	public String getAlternativeHeadline() {
		return _alternativeHeadline;
	}

	/**
	 * Returns the blog posting's body.
	 *
	 * @return the blog posting's body
	 */
	public String getArticleBody() {
		return _articleBody;
	}

	public BlogPostingCommentCreatorForm getBlogPostingCommentCreatorForm() {
		return _blogPostingCommentCreatorForm;
	}

	public List<BlogPostingCommentCreatorForm>
		getBlogPostingCommentCreatorForms() {

		return _blogPostingCommentCreatorForms;
	}

	/**
	 * Returns the blog posting's creator ID.
	 *
	 * @return the blog posting's creator ID
	 */
	public Long getCreator() {
		return _creator;
	}

	/**
	 * Returns the blog posting's headline.
	 *
	 * @return the blog posting's headline
	 */
	public String getHeadline() {
		return _headline;
	}

	private void _setAlternativeHeadline(String lastName) {
		_alternativeHeadline = lastName;
	}

	private void _setArticleBody(String articleBody) {
		_articleBody = articleBody;
	}

	private void _setBlogPostingCommentCreatorForm(
		BlogPostingCommentCreatorForm blogPostingCommentCreatorForm) {

		_blogPostingCommentCreatorForm = blogPostingCommentCreatorForm;
	}

	private void _setBlogPostingCommentCreatorForms(
		List<BlogPostingCommentCreatorForm> blogPostingCommentCreatorForms) {

		_blogPostingCommentCreatorForms = blogPostingCommentCreatorForms;
	}

	private void _setCreator(Long creator) {
		_creator = creator;
	}

	private void _setHeadline(String headline) {
		_headline = headline;
	}

	private String _alternativeHeadline;
	private String _articleBody;
	private BlogPostingCommentCreatorForm _blogPostingCommentCreatorForm;
	private List<BlogPostingCommentCreatorForm>
		_blogPostingCommentCreatorForms = new ArrayList<>();
	private Long _creator;
	private String _headline;

}