package com.ragnarok.model;

import java.awt.Color;
import java.awt.Graphics;

import com.ragnarok.controller.BaseGame;
import com.ragnarok.controller.utils.Vector2;

public class Racket implements Drawable
{

	private Vector2 position;
	private int lastPositionY;
	private Vector2 size;
	private Vector2 direction;
	private Vector2 speed;
	private Player player;

	public Racket(int numberPlayer)
	{

		this.size = new Vector2(8, 36);
		if (numberPlayer == 1)
		{
			this.position = new Vector2(20, BaseGame.GAME_WINDOW_HEIGHT / 2 - this.size.X);
		} else if (numberPlayer == 2)
		{
			this.position = new Vector2(BaseGame.GAME_WINDOW_WIDTH - 20 - this.size.X,
					BaseGame.GAME_WINDOW_HEIGHT / 2 - this.size.X);
		}
		this.lastPositionY = this.getPositionY();
		this.player = new Player(numberPlayer);
		/* The racket only have 2 directions UP or DOWN */
		this.speed = new Vector2(0, 1);
		this.direction = new Vector2(0, 1);

	}

	public boolean collideWithBall(Ball ball, int player)
	{
		if(player == 1)
			if(this.getPositionX() + this.getSize().getX() > ball.getPositionX() + ball.getSize()
			&& this.getPositionY() < ball.getPositionY() && this.getPositionY() + this.getSize().getY() > ball.getPositionY() + ball.getSize())
				return true;
		if(player == 2)
			if(this.getPositionX() + this.getSize().getX() < ball.getPositionX() + ball.getSize()
			&& this.getPositionY() < ball.getPositionY() && this.getPositionY() + this.getSize().getY() > ball.getPositionY() + ball.getSize())
				return true;
		return false;
	}

	public void move()
	{
		this.setLastPositionY(this.getPositionY());
		this.setPositionY(this.getPositionY() + this.getSize().getY() * this.speed.getY() * this.direction.getY());
	}

	public boolean isOutOfWindow(int windowHeight)
	{
		if (this.getPositionY() + this.getSize().getY() > windowHeight || this.getPositionY() < 0)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(this.getPositionX(), this.getPositionY(), this.getSize().X, this.getSize().Y);
	}
	
	public int getLastPositionY()
	{
		return lastPositionY;
	}

	public void setLastPositionY(int lastPositionY)
	{
		this.lastPositionY = lastPositionY;
	}

	public Vector2 getPosition()
	{
		return position;
	}

	public void setPosition(Vector2 position)
	{
		this.position = position;
	}

	public Vector2 getSize()
	{
		return size;
	}

	public void setSize(Vector2 size)
	{
		this.size = size;
	}

	public Vector2 getDirection()
	{
		return direction;
	}

	public void setDirection(Vector2 direction)
	{
		this.direction = direction;
	}

	public Vector2 getSpeed()
	{
		return speed;
	}

	public void setSpeed(Vector2 speed)
	{
		this.speed = speed;
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public void setPositionX(int position)
	{
		this.position.setX(position);
	}

	public void setPositionY(int position)
	{
		this.position.setY(position);
	}

	public int getPositionX()
	{
		return this.getPosition().getX();
	}

	public int getPositionY()
	{
		return this.getPosition().getY();
	}

}
