package com.ontimize.jee.common.exceptions;

import java.util.Arrays;

import com.ontimize.jee.common.tools.MessageType;

/**
 * General exceptions launched by the framework.
 *
 * @author joaquin.romero
 */
public class OntimizeJEEException extends Exception implements IParametrizedException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The msg type. */
	private final MessageType	msgType;

	/** The msg blocking. */
	private final boolean		msgBlocking;

	/** The msg parameters. */
	private final Object[] msgParameters;

	/** The silent. */
	private boolean				silent;


	public OntimizeJEEException() {
		this((String) null);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 */
	public OntimizeJEEException(String message) {
		this(message, (Throwable) null);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 */
	public OntimizeJEEException(String message, Throwable cause) {
		this(message, null, cause);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 * @param msgParameters
	 *            the msg parameters
	 */
	public OntimizeJEEException(String message, Object[] msgParameters) {
		this(message, msgParameters, MessageType.ERROR);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 * @param msgParameters
	 *            the msg parameters
	 * @param messageType
	 *            the message type
	 */
	public OntimizeJEEException(String message, Object[] msgParameters, MessageType messageType) {
		this(message, msgParameters, messageType, true);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 * @param msgParameters
	 *            the msg parameters
	 * @param cause
	 *            the cause
	 */
	public OntimizeJEEException(String message, Object[] msgParameters, Throwable cause) {
		this(message, msgParameters, cause, MessageType.ERROR, true, false);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 * @param msgParameters
	 *            the msg parameters
	 * @param msgType
	 *            the msg type
	 * @param msgBlocking
	 *            the msg blocking
	 */
	public OntimizeJEEException(String message, Object[] msgParameters, MessageType msgType, boolean msgBlocking) {
		this(message, msgParameters, null, msgType, msgBlocking, false);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public OntimizeJEEException(Throwable cause) {
		this(null, null, cause);
	}

	/**
	 * Instantiates a new u exception.
	 *
	 * @param message
	 *            the message
	 * @param msgParameters
	 *            the msg parameters
	 * @param cause
	 *            the cause
	 * @param msgType
	 *            the msg type
	 * @param msgBlocking
	 *            the msg blocking
	 * @param silent
	 *            the silent
	 */
	public OntimizeJEEException(String message, Object[] msgParameters, Throwable cause, MessageType msgType, boolean msgBlocking, boolean silent) {
		super(message, cause);
		this.msgType = msgType == null ? MessageType.ERROR : msgType;
		this.msgBlocking = msgBlocking;
		this.msgParameters = msgParameters == null ? null : Arrays.copyOf(msgParameters, msgParameters.length);
		this.silent = silent;
	}

	/**
	 * Instantiates a new ontimize jee exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param msgParameters
	 *            the msg parameters
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public OntimizeJEEException(String message, Throwable cause, Object[] msgParameters, MessageType msgType, boolean msgBlocking, boolean silent, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.msgType = msgType == null ? MessageType.ERROR : msgType;
		this.msgBlocking = msgBlocking;
		this.msgParameters = msgParameters == null ? null : Arrays.copyOf(msgParameters, msgParameters.length);
		this.silent = silent;
	}

	/**
	 * Instantiates a new ontimize jee exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public OntimizeJEEException(String message, Throwable cause, MessageType msgType, boolean msgBlocking, boolean silent, boolean enableSuppression, boolean writableStackTrace) {
		this(message, cause, null, msgType, msgBlocking, silent, enableSuppression, writableStackTrace);
	}

	/**
	 * Gets the msg parameters.
	 *
	 * @return the msg parameters
	 */
	@Override
	public Object[] getMessageParameters() {
		return this.msgParameters == null ? null : Arrays.copyOf(this.msgParameters, this.msgParameters.length);
	}

	/**
	 * Devuelve el tipo de mensaje que se mostrara al usuario.
	 *
	 * @return the message type
	 */
	@Override
	public MessageType getMessageType() {
		return this.msgType;
	}

	/**
	 * Devuelve si el mensaje que se mostrara al usuario sera bloqueante o no.
	 *
	 * @return true, if is message blocking
	 */
	@Override
	public boolean isMessageBlocking() {
		return this.msgBlocking;
	}

	/**
	 * Establece si se debe mostrar un mensaje en la UI.
	 *
	 * @param silent
	 *            the new silent
	 */
	public void setSilent(boolean silent) {
		this.silent = silent;
	}

	/**
	 * Checks if is silent.
	 *
	 * @return true, if is silent
	 */
	@Override
	public boolean isSilent() {
		return this.silent;
	}
}
