package pl.admonster.model.movingObject;

import pl.admonster.service.Game;

public interface TriggeredByMovingObject {
    void contactWithMovingObject(final Game game);
}
